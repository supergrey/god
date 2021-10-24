package pl.sdag2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private UserType userType = UserType.NORMAL;
    @OneToOne
    private Wallet wallet;
}

