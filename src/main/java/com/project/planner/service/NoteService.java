package com.project.planner.service;

import com.project.planner.model.Note;
import com.project.planner.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

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

    public List<Note> findByDateAndUserUserName(Date date, String userName) {
        return noteRepository.findByDateAndUserUserName(date, userName);
    }

    public List<Note> findByDateAndTimeAndUserUserName(Date date, String time, String userName) {
        return noteRepository.findByDateAndTimeAndUserUserName(date, time, userName);
    }

    public List<Note> findByUserUserName(String userName) {
        return noteRepository.findByUserUserName(userName);
    }

    public void deleteById (Long id) {
        noteRepository.deleteById(id);
    }

    public Note findById(Long id){
        return noteRepository.getOne(id);
    }
}
