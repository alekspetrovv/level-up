package level.up.example.repository;

import level.up.example.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    User findUserById(Long id);

    User findUserByEmail(String email);
}
