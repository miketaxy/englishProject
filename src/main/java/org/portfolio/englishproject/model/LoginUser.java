package org.portfolio.englishproject.model;

import lombok.Data;

@Data
public class LoginUser {
    private String username;
    private String password;
    private Role role;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.valueOf("USER");
    }
}
