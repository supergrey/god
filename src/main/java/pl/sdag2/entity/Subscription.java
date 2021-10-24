package pl.sdag2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Game game;
    private String user;
    private LocalDate expireDate;

//    public String getGame_Title() {
//        return game.getTitle();
//    }
}
