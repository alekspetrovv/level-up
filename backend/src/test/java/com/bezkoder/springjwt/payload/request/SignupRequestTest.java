package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SignupRequestTest {

    @Test
    void getUsername() {
        String email = "email";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setUsername(email);
        assertNotNull(signUpRequest);
        assertEquals(email, signUpRequest.getUsername());
    }

    @Test
    void setUsername() {
        String email = "email";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setUsername(email);
        assertNotNull(signUpRequest);
        assertEquals(email, signUpRequest.getUsername());
    }

    @Test
    void getEmail() {
        String email = "email";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail(email);
        assertNotNull(signUpRequest);
        assertEquals(email, signUpRequest.getEmail());
    }

    @Test
    void setEmail() {
        String email = "email";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail(email);
        assertNotNull(signUpRequest);
        assertEquals(email, signUpRequest.getEmail());
    }

    @Test
    void getPassword() {
        String password = "test";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setPassword(password);
        assertNotNull(signUpRequest);
        assertEquals(password, signUpRequest.getPassword());
    }

    @Test
    void setPassword() {
        String password = "test";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setPassword(password);
        assertNotNull(signUpRequest);
        assertEquals(password, signUpRequest.getPassword());
    }

    @Test
    void getRoles() {
        Set<String> roles = new HashSet<>();
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setRole(roles);
        assertNotNull(signupRequest);
        assertEquals(roles, signupRequest.getRole());
    }

    @Test
    void setRoles() {
        Set<String> roles = new HashSet<>();
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setRole(roles);
        assertNotNull(signupRequest);
        assertEquals(roles, signupRequest.getRole());
    }
}