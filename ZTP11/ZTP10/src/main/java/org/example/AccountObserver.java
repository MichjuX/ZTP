package org.example;

public interface AccountObserver {
    void update(BankAccount account, String operation, double amount);
}
