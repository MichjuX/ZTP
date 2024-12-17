package org.example;

import java.util.ArrayList;
import java.util.List;

class BankAccount {
    // Właściciel konta
    private String accountHolder;
    private double balance;
    private List<AccountObserver> observers;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.observers = new ArrayList<>();
    }

    // Getter dla właściciela konta
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter dla aktualnego stanu konta
    public double getBalance() {
        return balance;
    }

    // Wpłacanie pieniędzy na konto
    public void addObserver(AccountObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AccountObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String operation, double amount) {
        for (AccountObserver observer : observers) {
            observer.update(this, operation, amount);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        notifyObservers("deposit", amount);
        System.out.printf("Deposit: %.2f. New balance: %.2f.%n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds in the account.");
        }
        balance -= amount;
        notifyObservers("withdrawal", amount);
        System.out.printf("Withdrawal: %.2f. New balance: %.2f.%n", amount, balance);
    }
}
