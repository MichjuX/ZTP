package org.example;

public class CreditCardOfferModule implements AccountObserver {
    private int withdrawalCount = 0;
    private static final int WITHDRAWAL_THRESHOLD = 5;

    @Override
    public void update(BankAccount account, String operation, double amount) {
        if ("withdrawal".equals(operation)) {
            withdrawalCount++;
            if (withdrawalCount >= WITHDRAWAL_THRESHOLD) {
                System.out.println("Credit card offer: You've made several withdrawals. Consider applying for a credit card.");
                withdrawalCount = 0; // Reset counter
            }
        }
    }
}
