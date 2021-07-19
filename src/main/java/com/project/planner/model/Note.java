package com.project.planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "note_")
    private String note_;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private String time;

    @ManyToOne
    private User user;
    public Note() {

    }
}

