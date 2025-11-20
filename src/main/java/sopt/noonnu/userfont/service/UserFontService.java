package sopt.noonnu.userfont.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.noonnu.font.domain.Font;
import sopt.noonnu.font.service.FontService;
import sopt.noonnu.user.domain.User;
import sopt.noonnu.user.service.UserService;
import sopt.noonnu.userfont.domain.UserFonts;
import sopt.noonnu.userfont.dto.command.UpdateFontFlagCommandDto;
import sopt.noonnu.userfont.repository.UserFontRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFontService {

    private final UserFontRepository userFontRepository;
    private final FontService fontService;
    private final UserService userService;

    @Transactional
    public void updateLikeFont(UpdateFontFlagCommandDto command) {
        updateFontFlag(command, UserFonts::updateIsLiked);
    }

    @Transactional
    public void updateCompareFont(UpdateFontFlagCommandDto command) {
        updateFontFlag(command, UserFonts::updateIsCompared);
    }

    @Transactional(readOnly = true)
    public Map<Long, UserFonts> getUserFontMapByUserId(Long userId) {
        List<UserFonts> userFonts = userFontRepository.findByUserId(userId);
        return userFonts.stream()
                .collect(Collectors.toMap(
                        uf -> uf.getFont().getId(),
                        uf -> uf
                ));
    }

    @Transactional(readOnly = true)
    public List<Font> getComparedFontPreviews(Long userId) {
        List<UserFonts> userFonts = userFontRepository.findByUserIdAndIsComparedTrue(userId);

        return userFonts.stream()
                .map(UserFonts::getFont)
                .toList();
    }

    private UserFonts createUserFont(
            User user,
            Font font,
            BiConsumer<UserFonts, Boolean> flagUpdater
    ) {
        UserFonts userFont = UserFonts.create(user, font, false, false);
        flagUpdater.accept(userFont, true);
        return userFont;
    }


    private void updateFontFlag(
            UpdateFontFlagCommandDto command,
            BiConsumer<UserFonts, Boolean> flagUpdater
    ) {
        Font font = fontService.getFont(command.fontId());
        User user = userService.getUser(command.userId());

        Optional<UserFonts> userFontOpt = userFontRepository
                .findByUserIdAndFontId(command.userId(), command.fontId());

        if (userFontOpt.isPresent()) {
            UserFonts userFont = userFontOpt.get();
            flagUpdater.accept(userFont, command.isTrue());

            if (!userFont.isLiked() && !userFont.isCompared()) {
                userFontRepository.delete(userFont);
            }
        } else {
            if (command.isTrue()) {
                UserFonts newUserFont = createUserFont(user, font, flagUpdater);
                userFontRepository.save(newUserFont);
            }
        }
    }
}
