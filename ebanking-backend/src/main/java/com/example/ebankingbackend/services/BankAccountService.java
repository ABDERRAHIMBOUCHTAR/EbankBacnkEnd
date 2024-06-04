package com.example.ebankingbackend.services;

import com.example.ebankingbackend.dtos.*;
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.exceptions.BalanceNotDSufficientException;
import com.example.ebankingbackend.exceptions.BankAccountNotDFoundException;
import com.example.ebankingbackend.exceptions.CustomerNotFOundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double OverDraft, Long customerId) throws CustomerNotFOundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double InterestRate, Long customerId) throws CustomerNotFOundException;
    List<CustomerDTO> listCustomers();

    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotDFoundException;

    void debit(String accountId, double amount, String description) throws BalanceNotDSufficientException, BankAccountNotDFoundException;
    void credit(String accountId, double amount, String description) throws BalanceNotDSufficientException, BankAccountNotDFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotDFoundException, BalanceNotDSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFOundException;

    void deleteCustomer(Long customerId) throws CustomerNotFOundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    List<AccoutOperationDTO> accountHistory(String accountId) throws BankAccountNotDFoundException;

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotDFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}