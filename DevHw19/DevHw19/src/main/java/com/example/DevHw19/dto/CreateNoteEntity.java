package com.example.DevHw19.dto;

import com.example.DevHw19.entity.Note;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNoteEntity {
    private long id;
    private Status status;

    public enum Status{
        ok,
        badTitle,
        badContent,
        notExist
    }
}
