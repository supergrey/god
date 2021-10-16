package pl.sdag2.entity;

import lombok.Getter;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Getter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private DecimalFormat priceFor24h;


}
