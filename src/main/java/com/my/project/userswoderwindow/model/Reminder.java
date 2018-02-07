package com.my.project.userswoderwindow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reminders")
public class Reminder implements Serializable, Comparable<Reminder> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
//    @Column(name = "date")
//    private LocalDate date;
    @Column(name = "title")
    private String title;
    @Column(name = "about")
    private String about;

    @Override
    public int compareTo(Reminder that) {
        return Long.compare(this.id, that.id);
    }
}
