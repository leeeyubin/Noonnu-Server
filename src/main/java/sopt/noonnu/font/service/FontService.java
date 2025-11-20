package sopt.noonnu.font.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.noonnu.font.domain.Font;
import sopt.noonnu.font.exception.FontErrorCode;
import sopt.noonnu.font.repository.FontRepository;
import sopt.noonnu.global.exception.BaseException;

@Service
@RequiredArgsConstructor
public class FontService {
    private final FontRepository fontRepository;

    public Font getFont(Long fontId){
        return fontRepository.findById(fontId)
                .orElseThrow(() -> BaseException.type(FontErrorCode.NOT_FOUND_FONT));
    }
}
