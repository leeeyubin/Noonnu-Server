package sopt.noonnu.font.domain;

import lombok.Getter;

@Getter
public enum EFontLicense {
    PRINT("인쇄"),
    WEB("웹사이트"),
    PACKAGE("포장지"),
    VIDEO("영상"),
    EMBEDDING("임베딩"),
    BI_CI("BI/CI"),
    OFL("OFL");

    private final String description;

    EFontLicense(String description) {
        this.description = description;
    }
}
