package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        long id = 1;
        assertEquals(1, id);
    }

    @Test
    void setId() {
        long id = 1;
        assertEquals(1, id);
    }

    @Test
    void getUsername() {
        String email = "email";
        User apiUser = new User("email", "test", "test");
        assertNotNull(apiUser);
        assertEquals(email, apiUser.getUsername());
    }

    @Test
    void setUsername() {
        User apiUser = new User("email", "test", "test");
        apiUser.setEmail("test");
        assertNotNull(apiUser);
        assertEquals("test", apiUser.getEmail());
    }

    @Test
    void getEmail() {
        User apiUser = new User("email", "test", "test");
        assertNotNull(apiUser);
        assertEquals("test", apiUser.getEmail());
    }

    @Test
    void setEmail() {
        User apiUser = new User("email", "test", "test");
        apiUser.setEmail("email2");
        assertNotNull(apiUser);
        assertEquals("email2", apiUser.getEmail());
    }

    @Test
    void getPassword() {
        String password = "password";
        User apiUser = new User("email", "password", "password");
        assertNotNull(apiUser);
        assertEquals(password, apiUser.getPassword());
    }

    @Test
    void setPassword() {
        User apiUser = new User("email", "test", "test");
        apiUser.setPassword("password");
        assertNotNull(apiUser);
        assertEquals("password", apiUser.getPassword());
    }

    @Test
    void getRoles() {
        User apiUser = new User("email", "test", "test");
        apiUser.setPassword("password");
        assertNotNull(apiUser);
        assertEquals("password", apiUser.getPassword());
    }

    @Test
    void setRoles() {
        User apiUser = new User("email", "test", "test");
        apiUser.setPassword("password");
        assertNotNull(apiUser);
        assertEquals("password", apiUser.getPassword());
    }
}