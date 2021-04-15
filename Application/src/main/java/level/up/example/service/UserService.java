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
        User existingUser = userRepository.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            throw new UserNotFoundException("User with email: " + user.getEmail() + " already exist!");
        }
        return userRepository.save(user);
    }

    public List<User> read() {
        return userRepository.findAll();
    }

    public User update(User user) {
        User existingUser = findUserById(user.getId());
        if (existingUser == null) {
            return null;
        }
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
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
        User existingUser = findUserById(id);
        if (existingUser == null) {
            return;
        }
        userRepository.deleteUserById(id);
    }

}
