package level.up.example.service;

import level.up.example.exception.UserNotFoundException;
import level.up.example.module.User;
import level.up.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> read() {
        return userRepository.findAll();
    }

    public User update(User user) {
        User existingUser = findUserById(user.getId());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        return userRepository.save(existingUser);
    }


    public User findUserById(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " was not found!");
        }
        return user;
    }


    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

}
