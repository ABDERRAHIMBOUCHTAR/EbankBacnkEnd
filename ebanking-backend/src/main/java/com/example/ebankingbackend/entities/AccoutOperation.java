package com.example.ebankingbackend.entities;

import com.example.ebankingbackend.enums.OpertationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccoutOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OpertationType type;
    //operation concerne un compte
    @ManyToOne
    private BankAccount bankAccount;
    private String description;
}
