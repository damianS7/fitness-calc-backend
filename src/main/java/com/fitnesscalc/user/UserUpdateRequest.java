package com.fitnesscalc.user;


public class UserUpdateRequest {
    private final String username;
    private final String email;
    private final String password;

    public UserUpdateRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
