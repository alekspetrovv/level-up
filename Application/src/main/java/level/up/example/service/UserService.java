package level.up.example.service;

import level.up.example.exception.UserNotFoundException;
import level.up.example.module.ApiUser;
import level.up.example.module.request.UserRequest;
import level.up.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public ApiUser readUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    public void createUser(UserRequest userRequest) {
        ApiUser u = new ApiUser();
        Optional<ApiUser> byEmail = userRepository.findByEmail(userRequest.getEmail());
        if (byEmail.isPresent()) {
            throw new RuntimeException("User is already registered.Please use different email.");
        }
        u.setEmail(userRequest.getEmail());
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        u.setFirstName(userRequest.getFirstName());
        u.setLastName(userRequest.getLastName());
        userRepository.save(u);
    }

    public List<ApiUser> read() {
        return userRepository.findAll();
    }

    public ApiUser update(ApiUser apiUser) {
        return userRepository.save(apiUser);
    }


    public ApiUser findUserById(Long id) {
        ApiUser apiUser = userRepository.findUserById(id);
        if (apiUser == null) {
            throw new UserNotFoundException("User with id " + id + " was not found!");
        }
        return apiUser;
    }


    @Transactional
    public void deleteUserById(Long id) {
        ApiUser existingApiUser = findUserById(id);
        if (existingApiUser == null) {
            return;
        }
        userRepository.deleteUserById(id);
    }

}
