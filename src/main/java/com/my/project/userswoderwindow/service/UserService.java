package com.my.project.userswoderwindow.service;

import com.my.project.userswoderwindow.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> getAll();
}
