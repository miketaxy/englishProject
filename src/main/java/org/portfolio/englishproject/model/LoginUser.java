package org.portfolio.englishproject.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public User toUser(String passwordEncode){
        return User.builder()
                .username(username)
                .password(passwordEncode)
                .role(role)
                .build();
    }
}
