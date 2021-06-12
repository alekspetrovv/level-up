package com.bezkoder.springjwt.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String s) {
        super(s);
    }
}
