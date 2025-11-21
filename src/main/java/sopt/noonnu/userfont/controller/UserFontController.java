package sopt.noonnu.userfont.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.noonnu.facade.FontFacadeService;
import sopt.noonnu.font.dto.response.FontPreviewListResponse;
import sopt.noonnu.userfont.dto.command.UpdateFontFlagCommandDto;
import sopt.noonnu.userfont.dto.request.UpdateCompareFlagRequestDto;
import sopt.noonnu.userfont.dto.request.UpdateLikeFlagRequestDto;
import sopt.noonnu.userfont.service.UserFontService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserFontController implements UserFontApi {

    private final FontFacadeService  fontFacadeService;

    @PostMapping("/user/fonts/{fontId}/like")
    public void updateLikeFont(
            @RequestHeader Long userId,
            @PathVariable Long fontId,
            @RequestBody UpdateLikeFlagRequestDto request){
        fontFacadeService.updateLikeFont(UpdateFontFlagCommandDto.of(userId, request, fontId));
    }

    @PostMapping("/user/fonts/{fontId}/compare")
    public void updateCompareFont(
            @RequestHeader Long userId,
            @PathVariable Long fontId,
            @RequestBody UpdateCompareFlagRequestDto request){
        fontFacadeService.updateCompareFont(UpdateFontFlagCommandDto.of(userId, request, fontId));
    }

    @GetMapping("/user/compared-fonts/preview")
    public FontPreviewListResponse getComparedFontPreviews(
            @RequestHeader("userId") Long userId
    ) {
        return fontFacadeService.getComparedFontPreviews(userId);
    }
}
