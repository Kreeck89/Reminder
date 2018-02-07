package com.my.project.userswoderwindow.repository;

import com.my.project.userswoderwindow.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
