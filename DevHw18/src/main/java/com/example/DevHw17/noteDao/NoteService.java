package com.example.DevHw17.noteDao;

import com.example.DevHw17.models.Note;
import com.example.DevHw17.reposetory.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    public void addNote(Note request) {
        noteRepository.save(request);
    }


    public void editNote(Note request2) {
        noteRepository.save(request2);
    }

    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }

    public Note getNote(Integer id) {
        return noteRepository.findById(id).orElseThrow();
    }
}
