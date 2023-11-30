package studying.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import studying.dao.NoteDao;
import studying.models.Note;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteDao noteDao;

    @Autowired
    public NoteController(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @GetMapping("/list")
    public String getNotes(Model model) {
        model.addAttribute("notes", noteDao.showAllNote());
        return "notes/getNotes";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id,Model model){
        model.addAttribute("note",noteDao.show(id));
        return "notes/show";
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        noteDao.delete(id);
        return "redirect:/note/list";
    }

    @GetMapping("/{id}/edit")
    public String editNote(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteDao.show(id));
        return "notes/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("note") @Valid Note note, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors()){
            return "notes/edit";
        }
        noteDao.update(id, note);
        return "redirect:/note/list";
    }
}
