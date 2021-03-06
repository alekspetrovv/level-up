package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        long id = 1;
        User user = new User();
        user.setId(id);
        assertEquals(id, (long) user.getId());
    }

    @Test
    void createUser() {
        new User();
    }

    @Test
    void setId() {
        long id = 1;
        User user = new User();
        user.setId(id);
        assertEquals(id, (long) user.getId());
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
        apiUser.setUsername("test");
        assertNotNull(apiUser);
        assertEquals("test", apiUser.getUsername());
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
        ERole erole = ERole.ROLE_USER;
        Role role = new Role(erole);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User apiUser = new User("email", "test", "test");
        apiUser.setPassword("password");
        apiUser.setRoles(roles);
        assertNotNull(apiUser);
        assertEquals(roles, apiUser.getRoles());
    }

    @Test
    void setRoles() {
        ERole erole = ERole.ROLE_USER;
        Role role = new Role(erole);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User apiUser = new User("email", "test", "test");
        apiUser.setPassword("password");
        apiUser.setRoles(roles);
        assertNotNull(apiUser);
        assertEquals(roles, apiUser.getRoles());
    }
}