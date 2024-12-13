package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Login;

public interface LoginService {
    // Create or Update a Login
    Login Login(Login login);

    // Get Login by ID
    Login getLoginById(Long id);

    // Get all Logins
    List<Login> getAllLogins();

    // Delete Login by ID
    void deleteLoginById(Long id);

    // Authenticate user by username and password
    Login authenticateUser(String username, String password);
}
