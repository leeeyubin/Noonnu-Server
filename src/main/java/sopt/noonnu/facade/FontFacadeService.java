package sopt.noonnu.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.noonnu.font.domain.Font;
import sopt.noonnu.font.service.FontService;
import sopt.noonnu.user.domain.User;
import sopt.noonnu.user.service.UserService;
import sopt.noonnu.userfont.dto.command.UpdateFontFlagCommandDto;
import sopt.noonnu.userfont.service.UserFontService;

@Service
@RequiredArgsConstructor
public class FontFacadeService {
    private final UserService userService;
    private final FontService fontService;
    private final UserFontService userFontService;

    @Transactional
    public void updateLikeFont(UpdateFontFlagCommandDto command){
        Font font = fontService.getFont(command.fontId());
        User user = userService.getUser(command.userId());
        userFontService.updateLikeFont(font, user, command.isTrue());
    }


    @Transactional
    public void updateCompareFont(UpdateFontFlagCommandDto command){
        Font font = fontService.getFont(command.fontId());
        User user = userService.getUser(command.userId());
        userFontService.updateCompareFont(font, user, command.isTrue());
    }
}
