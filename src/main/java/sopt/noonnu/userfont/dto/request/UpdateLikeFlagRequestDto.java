package sopt.noonnu.userfont.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateLikeFlagRequestDto(
        @NotNull
        boolean isLiked
) {
}
