package sopt.noonnu.userfont.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.noonnu.userfont.dto.command.UpdateFontFlagCommandDto;
import sopt.noonnu.userfont.dto.request.UpdateCompareFlagRequestDto;
import sopt.noonnu.userfont.dto.request.UpdateLikeFlagRequestDto;
import sopt.noonnu.userfont.service.UserFontService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserFontController {

    private final UserFontService userFontService;

    @PostMapping("/user/fonts/{fontId}/like")
    public void updateLikeFont(
            @RequestHeader Long userId,
            @PathVariable Long fontId,
            @RequestBody UpdateLikeFlagRequestDto request){
        userFontService.updateLikeFont(UpdateFontFlagCommandDto.of(userId, request, fontId));
    }

    @PostMapping("/user/fonts/{fontId}/compare")
    public void updateCompareFont(
            @RequestHeader Long userId,
            @PathVariable Long fontId,
            @RequestBody UpdateCompareFlagRequestDto request){
        userFontService.updateCompareFont(UpdateFontFlagCommandDto.of(userId, request, fontId));
    }
}
