package sopt.noonnu.userfont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.noonnu.userfont.domain.UserFonts;

import java.util.Optional;

public interface UserFontRepository extends JpaRepository<UserFonts, Long> {

    Optional<UserFonts> findByUserIdAndFontId(Long userId, Long fontId);

}
