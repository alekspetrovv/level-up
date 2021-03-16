package project.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.module.Admin;
import project.module.User;
import project.repository.FakeData;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final FakeData fakedata = new FakeData();

    @GetMapping("/hello")
    @ResponseBody
    public String welcomeMessage() {
        return "Welcome to Level Up!";
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = fakedata.getUsers();

        if (users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("{uname}")
    public ResponseEntity<User> getUserName(@PathVariable(value = "uname") String name) {
        User user = fakedata.get(name);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        if (!fakedata.add(user)) {
            String entity = "User with username:  " + user.getUserName() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "User" + "/" + user.getUserName();
            URI uri = URI.create(url);
            return new ResponseEntity(uri, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (fakedata.update(user)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid username.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uname}")
    public ResponseEntity<User> deleteUser(@PathVariable String uname) {
        fakedata.delete(uname);
        return ResponseEntity.noContent().build();
    }

}
