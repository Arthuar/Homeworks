package com.example.webapp;

import com.example.webapp.exception.NoSuchNoteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NoteService {

    List<Note> notes = new ArrayList<>();
    AtomicInteger idCounter = new AtomicInteger(0);

    List<Note> listAll() {
        return notes;
    }

    Note add( Note note) {
        note.setId(idCounter.incrementAndGet());
        notes.add(note);
        return note;
    }

    void deleteById(long id) {
        Note noteDel = notes.stream()
                .filter(currentNote -> currentNote.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchNoteException::new);
        notes.remove(noteDel);

    }

    void update(Note note) {
        Note noteUp = notes.stream()
                .filter(currentNote -> currentNote.getId() == note.getId())
                .findFirst()
                .orElseThrow(NoSuchNoteException::new);
        noteUp.setTitle(note.getTitle());
        noteUp.setContent(note.getContent());

    }

    Note getById(long id) {
        return notes.stream()
                .filter(currentNote -> currentNote.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchNoteException::new);
    }
}
