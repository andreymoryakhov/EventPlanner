package com.project.planner.repository;

import com.project.planner.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByDate(Date date);
    List<Note> findByDateAndUserUserName(Date date, String userName);
    List<Note> findByDateAndTime(Date date, String time);
    List<Note> findByDateAndTimeAndUserUserName(Date date, String time, String userName);
    List<Note> findByUserUserName(String userName);
    //Optional<Note> findById(Long id);
}
