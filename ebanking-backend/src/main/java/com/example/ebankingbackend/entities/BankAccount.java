package com.example.ebankingbackend.entities;

import com.example.ebankingbackend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.login.AccountException;
import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @NoArgsConstructor
@AllArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    //Compte appartient a un client mais un client peut avoir plusieurs compte
    @ManyToOne
    private Customer customer;
    //Compte peut avoir plusieurs operations
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<AccoutOperation> accountOperations;


}
