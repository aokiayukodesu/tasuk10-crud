package com.mybatis.task10.demo;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super("message");
    }
}
