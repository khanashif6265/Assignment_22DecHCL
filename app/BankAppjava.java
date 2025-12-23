package com.bank.app;

public class BankAppjava {
    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(101, "Ashif Khan", 5000);

        try {
            account.showCustomerDetails();
            account.deposit(2000);
            account.withdraw(1000);
            account.withdraw(8000); // Exception case
        }
        catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Final Balance: " + account.checkBalance());
        }
    }
}

