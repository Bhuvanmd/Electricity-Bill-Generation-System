package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login Login(Login login) {
        return loginRepository.findByloginUserNameAndUserPassword(login.getLoginUserName(),login.getUserPassword()); // Handles both Create and Update
    }

    @Override
    public Login getLoginById(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Login not found with ID: " + id));
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @Override
    public void deleteLoginById(Long id) {
        if (!loginRepository.existsById(id)) {
            throw new RuntimeException("Login not found with ID: " + id);
        }
        loginRepository.deleteById(id);
    }

    @Override
    public Login authenticateUser(String username, String password) {
        Login login = loginRepository.findByloginUserNameAndUserPassword(username, password);
        if (login != null && login.getUserPassword().equals(password)) {
            return login;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
