package com.bezkoder.springjwt.exception;

public class ExpiredJwtException extends RuntimeException {
    public ExpiredJwtException(String s) {
        super(s);
    }
}
