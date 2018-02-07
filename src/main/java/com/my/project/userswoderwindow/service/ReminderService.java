package com.my.project.userswoderwindow.service;

import com.my.project.userswoderwindow.model.Reminder;

import java.util.List;

public interface ReminderService {

    void save(Reminder reminder);

    List<Reminder> getAll();
}
