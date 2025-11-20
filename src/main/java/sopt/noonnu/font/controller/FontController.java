package sopt.noonnu.font.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.noonnu.facade.FontFacadeService;
import sopt.noonnu.font.domain.*;
import sopt.noonnu.font.dto.response.FontListResponse;
import sopt.noonnu.font.dto.response.FontPreviewListResponse;
import sopt.noonnu.font.service.FontService;
import sopt.noonnu.font.dto.command.GetFontsCommand;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FontController implements FontApi{

    private final FontService fontService;
    private final FontFacadeService fontFacadeService;

    @GetMapping("/fonts")
    public FontListResponse getFonts(
            @RequestHeader(value = "userId") Long userId,
            @RequestParam(value = "sortBy", defaultValue = "POPULAR") EFontSort sortBy,
            @RequestParam(value = "thicknessNum", defaultValue = "1") int thicknessNum,
            @RequestParam(value = "purpose", required = false) List<EFontPurpose> purposes,
            @RequestParam(value = "shape", required = false) List<EFontShape> shapes,
            @RequestParam(value = "mood", required = false) List<EFontMood> moods,
            @RequestParam(value = "license", required = false) List<EFontLicense> licenses
    ) {
        GetFontsCommand command = GetFontsCommand.of(
                userId,
                sortBy,
                thicknessNum,
                purposes,
                shapes,
                moods,
                licenses
        );

        return fontFacadeService.getFonts(command);
    }
}
