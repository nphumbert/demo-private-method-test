package com.nphumbert;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class User {

    private final String login;
    private final String email;
    private final String password;

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = hash(password);
    }

    public String login() {
        return this.login;
    }

    public String email() {
        return this.email;
    }

    public String password() {
        return this.password;
    }

    private String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return Arrays.toString(md.digest(password.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
