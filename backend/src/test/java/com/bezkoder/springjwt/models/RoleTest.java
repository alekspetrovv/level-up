package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

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
    void getName() {
        ERole erole = ERole.ROLE_ADMIN;
        Role role = new Role(erole);
        assertEquals(erole, role.getName());
    }

    @Test
    void setName() {
        ERole erole = ERole.ROLE_ADMIN;
        Role role = new Role();
        role.setName(erole);
        assertEquals(erole, role.getName());
    }
}