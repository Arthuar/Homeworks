package entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Override
    public String toString(){
        return id + ") " + name;
    }
}