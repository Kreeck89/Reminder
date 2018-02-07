package com.my.project.userswoderwindow.service.impl;

import com.my.project.userswoderwindow.model.Reminder;
import com.my.project.userswoderwindow.repository.ReminderRepository;
import com.my.project.userswoderwindow.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository repository;

    @Override
    public void save(Reminder reminder) {
        repository.save(reminder);
    }

    @Override
    public List<Reminder> getAll() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
