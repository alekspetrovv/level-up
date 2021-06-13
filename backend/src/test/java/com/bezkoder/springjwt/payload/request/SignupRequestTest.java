package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import org.junit.jupiter.api.Test;

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
    void getRole() {
        String password = "test";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setPassword(password);
        assertNotNull(signUpRequest);
        assertEquals(password, signUpRequest.getPassword());
    }

    @Test
    void setRole() {
        String password = "test";
        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setPassword(password);
        assertNotNull(signUpRequest);
        assertEquals(password, signUpRequest.getPassword());
    }
}