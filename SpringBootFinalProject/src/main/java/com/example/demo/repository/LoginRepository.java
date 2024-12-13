package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    // Find a Login by username
    Login findByloginUserNameAndUserPassword(String loginUserName,String userPassword);
}
