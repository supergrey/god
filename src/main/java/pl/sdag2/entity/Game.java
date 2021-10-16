package pl.sdag2.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
