package com.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public User addUser(User u) {
        User ul = getByUserName(u.getUsername());
        if (ul == null) {
            userDao.save(u);
            return u;
        }
        return null;
    }

    @Override
    public User validate(String username, String password) {
        return userDao.validate(username, password);
    }

    @Override
    public List<User> getAll() {
        List<User> ulist = userDao.findAll();
        if (ulist.isEmpty()) {
            return null;
        }
        return ulist;
    }

    @Override
    @Transactional
    public void changePass(String uid, String newpass) {
        int rowsUpdated = userDao.changePass(uid, newpass);
        System.out.println(rowsUpdated);
    }
}
