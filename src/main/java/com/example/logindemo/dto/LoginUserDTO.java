package com.example.logindemo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author 24797
 * @version 1.0
 * @description user's DTO for login
 * @date 2025/12/14 13:42
 */

@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
