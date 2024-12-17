package org.example;

public class Ztp10 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jan Kowalski", 30    000);

        // Add observers
        account.addObserver(new CreditOfferModule());
        account.addObserver(new DepositOfferModule());
        account.addObserver(new CreditCardOfferModule());

        // Perform operations
        account.deposit(500);
        account.withdraw(2000);
        account.withdraw(1500);
        account.withdraw(1000);
        account.withdraw(800);
        account.withdraw(700); // This should trigger the credit card offer
        account.deposit(6000); // This should trigger the deposit offer

        System.out.printf("\nFinal balance: %.2f\n", account.getBalance());
    }
}
