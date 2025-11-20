package sopt.noonnu.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.noonnu.global.exception.BaseException;
import sopt.noonnu.user.domain.User;
import sopt.noonnu.user.exception.UserErrorCode;
import sopt.noonnu.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> BaseException.type(UserErrorCode.NOT_FOUND_USER));
    }
}
