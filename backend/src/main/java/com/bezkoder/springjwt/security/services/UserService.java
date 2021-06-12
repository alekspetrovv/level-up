package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.exception.UserNotFoundException;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> read() {
        return userRepository.findAll();
    }

    public User update(User user) {
        return userRepository.save(user);
    }


    public User findUserById(Long id) {
        User apiUser = userRepository.findUserById(id);
        if (apiUser == null) {
            throw new UserNotFoundException("User with id " + id + " was not found!");
        }
        return apiUser;
    }


    @Transactional
    public void deleteUserById(Long id) {
        User existingApiUser = findUserById(id);
        if (existingApiUser == null) {
            return;
        }
        userRepository.deleteUserById(id);
    }

}
