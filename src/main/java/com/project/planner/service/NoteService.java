package com.project.planner.service;

import com.project.planner.model.Note;
import com.project.planner.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findByDate(Date date) {
        return noteRepository.findByDate(date);
    }

    public List<Note> findByDateAndTime(Date date, String time) {
        return noteRepository.findByDateAndTime(date, time);
    }

    public List<Note> findByUserUserName(String userName) {
        return noteRepository.findByUserUserName(userName);
    }

    public void deleteById (Long id) {
        noteRepository.deleteById(id);
    }

    public Optional<Note> findById(Long id) {
       return noteRepository.findById(id);
    }
}
