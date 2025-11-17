package sopt.noonnu.font.domain;

import lombok.Getter;

@Getter
public enum EFontMood {
    ROUND("둥근"),
    ANGULAR("각진"),
    SIMPLE("심플한"),
    THICK("두꺼운"),
    FANCY("화려한"),
    CUTE("귀여운"),
    CHEERFUL("유쾌한"),
    CLASSIC("클래식"),
    RETRO("레트로"),
    FREE("자유로운"),
    EMOTIONAL("감성적인"),
    UNIQUE("독특한"),
    STRONG("강렬한");

    private final String description;

    EFontMood(String description) {
            this.description = description;
    }
}
