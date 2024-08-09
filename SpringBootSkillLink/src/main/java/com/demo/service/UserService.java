package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {

    User addUser(User u);

    User validate(String username, String password);

    List<User> getAll();

    void changePass(String uid, String newpass);
}
