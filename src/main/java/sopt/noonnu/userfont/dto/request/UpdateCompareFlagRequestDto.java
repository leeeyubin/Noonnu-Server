package sopt.noonnu.userfont.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateCompareFlagRequestDto(
        @NotNull
        boolean isCompared
) {
}
