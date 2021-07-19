package com.project.planner.repository;

import com.project.planner.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByDateAndUserUserName(Date date, String userName);
    List<Note> findByDateAndTimeAndUserUserName(Date date, String time, String userName);
    List<Note> findByUserUserName(String userName);
}
