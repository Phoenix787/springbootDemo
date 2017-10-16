package springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String s);
}