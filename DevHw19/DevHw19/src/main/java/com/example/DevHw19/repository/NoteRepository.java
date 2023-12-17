package com.example.DevHw19.repository;

import com.example.DevHw19.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
