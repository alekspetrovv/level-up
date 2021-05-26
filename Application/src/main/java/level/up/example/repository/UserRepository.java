package level.up.example.repository;

import level.up.example.module.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser, Long> {

    void deleteUserById(Long id);

    ApiUser findUserById(Long id);

    Optional<ApiUser> findByEmail(String email);
}
