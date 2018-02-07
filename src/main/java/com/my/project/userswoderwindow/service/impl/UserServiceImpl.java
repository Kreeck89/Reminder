package com.my.project.userswoderwindow.service.impl;

import com.my.project.userswoderwindow.model.User;
import com.my.project.userswoderwindow.repository.UserRepository;
import com.my.project.userswoderwindow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
