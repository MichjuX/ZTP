package org.example;

public class CreditOfferModule implements AccountObserver {
    private static final double LOW_BALANCE_THRESHOLD = 1000.0;

    @Override
    public void update(BankAccount account, String operation, double amount) {
        if (account.getBalance() < LOW_BALANCE_THRESHOLD) {
            System.out.println("Credit offer: Your balance is low. Consider taking a loan.");
        }
    }
}
