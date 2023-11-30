package studying.dao;

import org.springframework.stereotype.Component;
import studying.models.Note;
import java.util.ArrayList;
import java.util.List;

@Component
public class NoteDao {
    private static int NOTE_COUNT;
    private List<Note> notes;

    {
        notes = new ArrayList<>();
        notes.add(new Note(++NOTE_COUNT, "first_note", "Hello,this is the first note"));
        notes.add(new Note(++NOTE_COUNT, "second_note", "Hello,this is the second note"));
        notes.add(new Note(++NOTE_COUNT, "third_note", "Hello,this is the third note"));
        notes.add(new Note(++NOTE_COUNT, "fours_note", "Hello,this is the fours note"));
    }

    public List<Note> showAllNote() {
        return notes;
    }

    public void delete(int id) {
        notes.removeIf(currentId -> currentId.getId() == id);
    }

    public Note show(int id) {
        return notes.stream().filter(currentId -> currentId.getId() == id).findAny().orElse(null);
    }

    public void update(int id, Note updateNote) {
        Note noteToUpdate = show(id);
        noteToUpdate.setTitle(updateNote.getTitle());
        noteToUpdate.setContent(updateNote.getContent());
        noteToUpdate.setId(updateNote.getId());
    }
}
