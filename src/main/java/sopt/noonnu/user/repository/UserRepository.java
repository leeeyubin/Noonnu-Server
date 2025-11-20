package sopt.noonnu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.noonnu.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
