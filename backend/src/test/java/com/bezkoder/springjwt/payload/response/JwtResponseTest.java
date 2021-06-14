package com.bezkoder.springjwt.payload.response;

import com.bezkoder.springjwt.models.ERole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JwtResponseTest {

    @Test
    void getAccessToken() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;

        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);

        assertEquals(token, jwtResponse.getAccessToken());
    }

    @Test
    void setAccessToken() {
        String token = "test";
        String type = "Bearer";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;

        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setAccessToken("hello");
        assertEquals("hello", jwtResponse.getAccessToken());
    }

    @Test
    void getTokenType() {
        String token = "test";
        String type = "Bearer";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;

        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setTokenType(type);
        assertEquals(type, jwtResponse.getTokenType());
    }

    @Test
    void setTokenType() {
        String token = "test";
        String type = "Bearer";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;

        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setTokenType(type);
        assertEquals(type, jwtResponse.getTokenType());
    }

    @Test
    void getId() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;

        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        assertEquals(id, jwtResponse.getId());

    }

    @Test
    void setId() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;
        Long setId = (long) 2;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setId(setId);
        assertEquals(setId, jwtResponse.getId());
    }

    @Test
    void getEmail() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        assertEquals(email, jwtResponse.getEmail());
    }

    @Test
    void setEmail() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        String setEmail = "alexx@gmail.com";
        List<String> roles = null;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setEmail(setEmail);
        assertEquals(setEmail, jwtResponse.getEmail());
    }

    @Test
    void getUsername() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        assertEquals(username, jwtResponse.getUsername());
    }

    @Test
    void setUsername() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        String setUserName = "test";
        List<String> roles = null;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        jwtResponse.setUsername(setUserName);
        assertEquals(setUserName, jwtResponse.getUsername());
    }

    @Test
    void getRoles() {
        String token = "test";
        Long id = (long) 1;
        String username = "alex";
        String email = "alex@gmail.com";
        List<String> roles = null;
        JwtResponse jwtResponse = new JwtResponse(token, id, username, email, null);
        assertEquals(null, jwtResponse.getRoles());
    }
}