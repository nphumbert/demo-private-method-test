package com.nphumbert;

public class User {

    private final String login;
    private final String email;
    private final String password;

    public User(String login, String email, String password, HashProvider hashProvider) {
        this.login = login;
        this.email = email;
        this.password = hashProvider.hash(password);
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

}
