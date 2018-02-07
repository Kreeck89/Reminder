package com.my.project.userswoderwindow.repository;

import com.my.project.userswoderwindow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
