package com.project.planner.controller;

import com.project.planner.model.Note;
import com.project.planner.model.User;
import com.project.planner.service.NoteService;
import com.project.planner.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

@Controller
public class NoteController {

    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String show() {
        return "main";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/view_note";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable("id") Long id, Principal principal) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Note note, Principal principal) {
        User user = userService.findByUserName(principal.getName()).get();
        note.setUser(user);
        noteService.save(note);
        return "redirect:/view_note";
    }

    @GetMapping("/view_note")
    public String view(Model model, Note note, Principal principal) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        model.addAttribute("notes", noteService.findByUserUserName(principal.getName()));
        return "view";
    }

    @PostMapping("/view")
    public String create(Note note, Principal principal) {
        User user = userService.findByUserName(principal.getName()).get();
        note.setUser(user);
        noteService.save(note);
        return "redirect:/view_note";
    }

    @GetMapping("/view_by_date")
    public String showByDate(Model model, @Param("date") Date date, Principal principal) {
        List<Note> notes = noteService.findByDateAndUserUserName(date, principal.getName());
        model.addAttribute("notes", notes);
        return "view_by_date";
    }

    @GetMapping("/view_by_date_and_time")
    public String showByDateAndTime(Model model, @Param("date") Date date, @Param("time") String time, Principal principal) {
        List<Note> notes = noteService.findByDateAndTimeAndUserUserName(date, time, principal.getName());
        model.addAttribute("notes", notes);
        return "view_by_date_and_time";
    }
}
