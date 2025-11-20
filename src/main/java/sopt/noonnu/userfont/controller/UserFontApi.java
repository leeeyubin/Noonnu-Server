package sopt.noonnu.userfont.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import sopt.noonnu.global.dto.CustomErrorResponse;
import sopt.noonnu.userfont.dto.request.UpdateCompareFlagRequestDto;
import sopt.noonnu.userfont.dto.request.UpdateLikeFlagRequestDto;

@Tag(name = "UserFont", description = "사용자 폰트 관련 API")
public interface UserFontApi {

    @Operation(
            summary = "폰트 좋아요 상태 변경",
            description = "사용자가 특정 폰트에 대한 좋아요 상태를 변경합니다. " +
                    "isLiked가 true면 좋아요 추가, false면 좋아요 해제됩니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "좋아요 상태 변경 성공",
                    content = @Content(schema = @Schema(implementation = sopt.noonnu.global.dto.ApiResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "폰트 또는 사용자를 찾을 수 없음",
                    content = @Content(schema = @Schema(implementation = CustomErrorResponse.class))
            )
    })
    @PostMapping("/user/fonts/{fontId}/like")
    void updateLikeFont(
            @Parameter(description = "사용자 ID", required = true)
            @RequestHeader Long userId,

            @Parameter(description = "폰트 ID", required = true)
            @PathVariable Long fontId,

            @Parameter(description = "좋아요 상태 (true: 추가, false: 해제)", required = true)
            @RequestBody UpdateLikeFlagRequestDto request
    );

    @Operation(
            summary = "폰트 비교하기 상태 변경",
            description = "사용자가 특정 폰트에 대한 비교하기 상태를 변경합니다. " +
                    "isCompared가 true면 비교함에 추가, false면 비교함에서 제거됩니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "비교하기 상태 변경 성공",
                    content = @Content(schema = @Schema(implementation = sopt.noonnu.global.dto.ApiResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "폰트 또는 사용자를 찾을 수 없음",
                    content = @Content(schema = @Schema(implementation = CustomErrorResponse.class))
            )
    })
    @PostMapping("/user/fonts/{fontId}/compare")
    void updateCompareFont(
            @Parameter(description = "사용자 ID", required = true)
            @RequestHeader Long userId,

            @Parameter(description = "폰트 ID", required = true)
            @PathVariable Long fontId,

            @Parameter(description = "비교하기 상태 (true: 추가, false: 제거)", required = true)
            @RequestBody UpdateCompareFlagRequestDto request
    );
}