package level.up.example.controller;

import level.up.example.module.request.UserRequest;
import level.up.example.service.UserService;
import level.up.example.module.ApiUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
//TODO later change the config file sign up to this url
@RequestMapping(value = "/users")
@Validated
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/all")
    public ResponseEntity<List<ApiUser>> getAll() {
        List<ApiUser> apiUsers = userService.read();
        if (apiUsers != null) {
            return ResponseEntity.ok().body(apiUsers);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiUser> getUser(@PathVariable("id") Long id) {
        ApiUser apiUser = userService.findUserById(id);
        if (apiUser != null) {
            return ResponseEntity.ok().body(apiUser);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/blogs")
    public ResponseEntity<?> getUserBlogs(@PathVariable("id") Long id) {
        ApiUser apiUser = userService.findUserById(id);
        if (apiUser != null) {
            return ResponseEntity.ok().body(apiUser.getBlogList());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiUser> update(
            @NotBlank @RequestParam("email") String email,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName,
            @PathVariable long id
    ) {
        ApiUser apiUser = userService.findUserById(id);
        apiUser.setEmail(email);
        apiUser.setPassword(password);
        apiUser.setFirstName(firstName);
        apiUser.setLastName(lastName);

        ApiUser updatedApiUser = userService.update(apiUser);
        return new ResponseEntity<>(updatedApiUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiUser> delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
