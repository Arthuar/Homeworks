package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private long id;

    @Column(name = "created_at")
    @Getter
    @Setter
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Planet toPlanet;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + client.getName() +
                ", fromPlanet=" + fromPlanet.getName() +
                ", toPlanet=" + toPlanet.getName() +
                '}';
    }
}
