package com.bank.app;

public abstract class BankingOperations {
    abstract void deposit(double amount) throws InvalidAmountException;

    abstract void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException;

    abstract double checkBalance();
}