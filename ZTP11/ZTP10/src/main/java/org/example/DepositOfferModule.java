package org.example;

public class DepositOfferModule implements AccountObserver {
    private static final double SIGNIFICANT_DEPOSIT = 5000.0;

    @Override
    public void update(BankAccount account, String operation, double amount) {
        if ("deposit".equals(operation) && amount >= SIGNIFICANT_DEPOSIT) {
            System.out.println("Deposit offer: You've made a significant deposit. Consider opening a savings account.");
        }
    }
}
