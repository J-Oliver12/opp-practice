package org.example.model;

import org.example.model.Customer;
import org.example.model.sequencer.AccountNumberGenerator;

public class BankAccount {

    private final long accountNumber;
    private double balance;
    private Customer customer;



    /*
    private static long accountNumberCounter = 0;                       ## moved to helper class "AccountNumberGenerator"

    private static long generateNextAccountNumber(){
        return ++accountNumberCounter;
    }


    public void setAccountNumber(long accountNumber) {                ## Not used, instead created "generateNextAccountNumber" above
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {                            ## Not logical to set account balance manually here.
        this.balance = balance;
    }
    */



    public BankAccount(double balance, Customer customer) {                          // ## Constructor - Using methods
        this.accountNumber = AccountNumberGenerator.generateNextAccountNumber();     // ## I.e. Classname.StaticMethodName
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer was null.");
        this.customer = customer;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Cannot deposit a negative amount.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        if (amount > balance) throw new IllegalArgumentException("Withdrawal denied: insufficient funds.");
        balance -= amount;

    }

}
