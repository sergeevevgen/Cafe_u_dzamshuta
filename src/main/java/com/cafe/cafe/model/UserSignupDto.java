package com.cafe.cafe.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserSignupDto {
    @NotBlank
    @Size(min = 3, max = 64)
    private String login;
    @NotBlank
    @Size(min = 6, max = 64)
    private String password;
    @NotBlank
    @Size(min = 6, max = 64)
    private String passwordConfirm;
    @NotBlank
    private String userRole;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
