package com.example.ebankingbackend.exceptions;

public class BankAccountNotDFoundException extends Exception {
    public BankAccountNotDFoundException(String message) {
        super(message);
    }
}
