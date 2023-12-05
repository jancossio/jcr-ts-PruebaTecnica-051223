package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.User;
import com.example.demo.dto.UserRecord;

public interface IUserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
    User getUser(String email);
    User update(User user);
}