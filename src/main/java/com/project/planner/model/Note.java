package com.project.planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

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
//    @DateTimeFormat (iso = DateTimeFormat.ISO.TIME)
    private String time;

    @ManyToOne
    private User user;
    public Note() {

    }
}

