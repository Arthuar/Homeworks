package com.example.DevHw17.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "note")
@Getter
@Setter
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public Note() {
    }

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
