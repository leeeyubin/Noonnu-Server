package sopt.noonnu.font.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FontMetadata {

    @Column(name = "font_family", nullable = false)
    private String fontFamily;

    @Column(name = "font_source", nullable = false)
    private String fontSource;

    @Column(name = "font_weight", nullable = false)
    private String fontWeight;

    @Column(name = "font_display", nullable = false)
    private String fontDisplay;

}
