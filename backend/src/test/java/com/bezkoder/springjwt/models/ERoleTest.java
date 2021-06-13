package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ERoleTest {

    @Test
    void values() {
        ERole eRole = ERole.ROLE_USER;
        assertEquals(ERole.ROLE_USER, eRole);
    }

    @Test
    void valueOf() {
        ERole eRole = ERole.ROLE_ADMIN;
        assertEquals(ERole.ROLE_ADMIN, eRole);
    }
}