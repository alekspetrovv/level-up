package level.up.example.controller;

import level.up.example.service.UserService;
import level.up.example.module.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.read();
        if (users != null) {
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<User> create(
            @NotBlank @RequestParam("email") String email,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName
    ) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @NotBlank @RequestParam("email") String email,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName,
            @PathVariable long id
    ) {
        User user = userService.findUserById(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
