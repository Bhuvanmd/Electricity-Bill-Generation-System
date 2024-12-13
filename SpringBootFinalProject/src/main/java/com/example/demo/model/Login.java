package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    private Long loginId;

    @Column(name = "loginRoleId", nullable = false)
    private Long loginRoleId;

    @Column(name = "login_user_name", nullable = false, unique = true)
    private String loginUserName;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    // Constructors
    public Login() {
    }

    public Login(Long loginRoleId, String loginUserName, String userPassword) {
        this.loginRoleId = loginRoleId;
        this.loginUserName = loginUserName;
        this.userPassword = userPassword;
    }

    // Getters and Setters
    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getLoginRoleId() {
        return loginRoleId;
    }

    public void setLoginRoleId(Long loginRoleId) {
        this.loginRoleId = loginRoleId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // toString Method
    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", loginRoleId=" + loginRoleId +
                ", loginUserName='" + loginUserName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
