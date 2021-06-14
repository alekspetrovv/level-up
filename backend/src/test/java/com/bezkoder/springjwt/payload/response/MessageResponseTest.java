package com.bezkoder.springjwt.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageResponseTest {

    @Test
    void getMessage() {
        String message = "hey";
        MessageResponse messageResponse = new MessageResponse(message);
        assertEquals(message, messageResponse.getMessage());
    }

    @Test
    void setMessage() {
        String message = "hey";
        MessageResponse messageResponse = new MessageResponse("");
        messageResponse.setMessage(message);
        assertEquals(message, messageResponse.getMessage());
    }
}