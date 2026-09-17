package wallet;

import exceptions.InsufficientFundsException;

public class WalletAccount {
	private double balance;

    public void Wallet(double balance) {

        this.balance = balance;

    }

    public double getBalance() {

        return balance;

    }

    public void withdraw(double amount) throws InsufficientFundsException {

        if (amount > balance) {

            throw new InsufficientFundsException(

                "Insufficient funds. Your balance is $" + balance

            );

        }

        balance = balance - amount;

        System.out.println("Withdrawal successful.");

        System.out.println("Amount withdrawn: $" + amount);

        System.out.println("Remaining balance: $" + balance);

    }

}
