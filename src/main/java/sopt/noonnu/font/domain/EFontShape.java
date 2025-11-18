package sopt.noonnu.font.domain;

import lombok.Getter;

@Getter
public enum EFontShape {
    BATANG("바탕"),
    DOTUM("돋움"),
    GULIM("굴림"),
    DECORATIVE("장식체"),
    HANDWRITING("손글씨");

    private final String description;

    EFontShape(String description) {
        this.description = description;
    }
}
