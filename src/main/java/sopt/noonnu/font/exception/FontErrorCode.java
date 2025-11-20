package sopt.noonnu.font.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sopt.noonnu.global.exception.ErrorCode;

@Getter
@AllArgsConstructor
public enum FontErrorCode implements ErrorCode {

    NOT_FOUND_FONT(HttpStatus.NOT_FOUND, "FONT_001", "폰트를 찾을 수 없습니다.");


    private final HttpStatus status;
    private final String prefix;
    private final String message;
}
