package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.BlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AuthControllerTest {

    @InjectMocks
    AuthController authController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    PasswordEncoder encoder;


    @Test
    void authenticateUser() {

    }

    @Test
    void registerUser() {
//
//        SignupRequest signupRequest = new SignupRequest();
//
//        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(), encoder.encode(signupRequest.getPassword()));
//
//
//
//        ResponseEntity<Blog> expected = ResponseEntity.ok().body(blog);
//
//        when(blogService.get((long) 1)).thenReturn(blog);
//
//        ResponseEntity<Blog> actual = blogController.read((long) 1);
//
//        Assertions.assertEquals(expected, actual);

    }
}