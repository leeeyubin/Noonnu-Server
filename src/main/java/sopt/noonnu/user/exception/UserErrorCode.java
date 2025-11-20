package sopt.noonnu.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sopt.noonnu.global.exception.ErrorCode;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCode {

    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "USER_001", "해당하는 유저를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String prefix;
    private final String message;
}
