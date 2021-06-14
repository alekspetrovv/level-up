package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getId() {
        Integer id = 1;
        Role role = new Role();
        role.setId(id);
        assertEquals(id, role.getId());
    }

    @Test
    void setId() {
        Integer id = 1;
        Role role = new Role();
        role.setId(id);
        assertEquals(id, role.getId());
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