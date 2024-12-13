package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Create or Update Login
    @PostMapping
    public ResponseEntity<Login> saveOrUpdateLogin(@RequestBody Login login) {
        return ResponseEntity.ok(loginService.Login(login));
    }

    // Get Login by ID
    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.getLoginById(id));
    }

    // Get All Logins
    @GetMapping
    public ResponseEntity<List<Login>> getAllLogins() {
        return ResponseEntity.ok(loginService.getAllLogins());
    }

    // Delete Login by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoginById(@PathVariable Long id) {
        loginService.deleteLoginById(id);
        return ResponseEntity.ok("Login with ID: " + id + " deleted successfully.");
    }

    // Authenticate Login
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestParam String username, @RequestParam String password) {
        try {
            Login login = loginService.authenticateUser(username, password);
            return ResponseEntity.ok("Login successful for user: " + login.getLoginUserName());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
