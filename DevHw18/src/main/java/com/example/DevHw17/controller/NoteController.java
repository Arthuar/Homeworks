package com.example.DevHw17.controller;

import com.example.DevHw17.models.Note;
import com.example.DevHw17.noteDao.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService service;

    @GetMapping("/list")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", service.getAllNotes());
        return "notes/list";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "notes/create";
    }

    @PostMapping("/create")
    public String saveNote(@ModelAttribute  Note note) {
        service.addNote(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        service.deleteNote(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String getEditNote(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("note", service.getNote(id));
        return "notes/edit";
    }

    @PostMapping("/edit/{id}")
    public String editNote(@ModelAttribute Note note) {
        service.editNote(note);
        return "redirect:/note/list";
    }
}
