package com.example.ebankingbackend.exceptions;

public class BalanceNotDSufficientException extends Exception {
    public BalanceNotDSufficientException(String message) {
        super(message);
    }
}
