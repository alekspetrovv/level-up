package com.bezkoder.springjwt.security.services;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsImplTest {

    @Test
    void build() {
    }

    @Test
    void getAuthorities() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(null, userDetails.getAuthorities());
    }

    @Test
    void getId() {

        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(id, userDetails.getId());
    }

    @Test
    void getEmail() {

        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(email, userDetails.getEmail());
    }

    @Test
    void getPassword() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(password, userDetails.getPassword());
    }

    @Test
    void getUsername() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(username, userDetails.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(true, userDetails.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(true, userDetails.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(true, userDetails.isCredentialsNonExpired());

    }

    @Test
    void isEnabled() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;

        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, email, password, authorities);

        assertEquals(true, userDetails.isEnabled());
    }

    @Test
    void testEquals() {
        Long id = (long) 1;

        String username = "test";

        String email = "test";


        String password = "password";

        Collection<? extends GrantedAuthority> authorities = null;


        assertEquals(true, new UserDetailsImpl(id, username, email, password, authorities).equals(new UserDetailsImpl(id, username, email, password, authorities)));

    }
}