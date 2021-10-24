package pl.sdag2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal accountBalance = BigDecimal.valueOf(0);
    private PayMethodEnum payMethod = PayMethodEnum.PAYPAL;
}
