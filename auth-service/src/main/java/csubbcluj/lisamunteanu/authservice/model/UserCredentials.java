package csubbcluj.lisamunteanu.authservice.model;

import java.io.Serializable;

public class UserCredentials implements Serializable {
    private String username, password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredentials() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
