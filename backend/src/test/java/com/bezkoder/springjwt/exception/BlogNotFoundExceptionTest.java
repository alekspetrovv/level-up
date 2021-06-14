package com.bezkoder.springjwt.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class BlogNotFoundExceptionTest {
    @Test
    void blogNotFound(){
        String message = "blog not found!";
        BlogNotFoundException blogNotFoundException = new BlogNotFoundException(message);
        assertNotNull(blogNotFoundException);
        assertEquals(message, blogNotFoundException.getMessage());
    }
}