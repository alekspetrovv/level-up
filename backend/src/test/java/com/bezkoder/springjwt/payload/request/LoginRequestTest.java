package com.bezkoder.springjwt.payload.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void getUsername() {
        String email = "email";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(email);
        assertNotNull(loginRequest);
        assertEquals(email, loginRequest.getUsername());
    }

    @Test
    void setUsername() {
        String email = "email";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(email);
        assertNotNull(loginRequest);
        assertEquals(email, loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        String password = "test";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(password);
        assertNotNull(loginRequest);
        assertEquals(password, loginRequest.getPassword());
    }

    @Test
    void setPassword() {

        String password = "test";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(password);
        assertNotNull(loginRequest);
        assertEquals(password, loginRequest.getPassword());

    }
}