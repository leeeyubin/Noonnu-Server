package sopt.noonnu.font.dto.response;

import sopt.noonnu.font.domain.Font;

import java.util.List;

public record FontPreviewListResponse(
        List<Item> items
) {
    public static FontPreviewListResponse from(List<Font> fonts) {
        List<Item> items = fonts.stream()
                .map(f -> new Item(f.getId(), f.getName()))
                .toList();
        return new FontPreviewListResponse(items);
    }

    public record Item(
            Long id,
            String name
    ) {
    }
}
