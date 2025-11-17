package sopt.noonnu.font.domain;

import lombok.Getter;

@Getter
public enum EFontPurpose {
    // 문서
    DOCUMENT_TITLE("제목용", "문서"),
    DOCUMENT_BODY("본문용", "문서"),
    DOCUMENT_DECORATIVE("장식용", "문서"),

    // 영상
    VIDEO_THUMBNAIL("썸네일용", "영상"),
    VIDEO_SUBTITLE("자막용", "영상"),

    // 디자인
    DESIGN_CARD_NEWS("카드뉴스용", "디자인"),
    DESIGN_POSTER("포스터용", "디자인"),
    DESIGN_PPT("PPT용", "디자인");

    private final String displayName;
    private final String category;

    EFontPurpose(String displayName, String category) {
        this.displayName = displayName;
        this.category = category;
    }

}
