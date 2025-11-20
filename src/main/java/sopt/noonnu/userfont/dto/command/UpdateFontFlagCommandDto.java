package sopt.noonnu.userfont.dto.command;

import sopt.noonnu.userfont.dto.request.UpdateCompareFlagRequestDto;
import sopt.noonnu.userfont.dto.request.UpdateLikeFlagRequestDto;

public record UpdateFontFlagCommandDto(

        Long userId,

        Long fontId,

        boolean isTrue

) {
    public static UpdateFontFlagCommandDto of(
            Long userId,
            UpdateLikeFlagRequestDto request,
            Long fontId) {
        return new UpdateFontFlagCommandDto(userId, fontId, request.isLiked());
    }

    public static UpdateFontFlagCommandDto of(
            Long userId,
            UpdateCompareFlagRequestDto request,
            Long fontId) {
        return new UpdateFontFlagCommandDto(userId, fontId, request.isCompared());
    }
}
