package sopt.noonnu.font.dto.response;

import java.util.List;

public record FontPreviewListResponse(
        List<FontPreviewResponse> fontPreviews
) {
    public static FontPreviewListResponse from(List<FontPreviewResponse> list) {
        return new FontPreviewListResponse(list);
    }

    public record FontPreviewResponse(
            Long id,
            String name
    ) {

    }
}
