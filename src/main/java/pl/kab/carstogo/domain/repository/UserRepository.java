package pl.kab.carstogo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kab.carstogo.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
