package io.inatagan.owlmap_api.controller;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
