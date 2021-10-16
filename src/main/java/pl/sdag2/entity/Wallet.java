package pl.sdag2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private int accountBalance;
    private PayMethod payMethod;

    }

enum PayMethod {
    CREDIT_CARD, PAYPAL
}

