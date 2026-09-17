package psu.edu.sa5;

import exceptions.InsufficientFundsException;
import wallet.WalletAccount;

public class EX2 {
	public static void main(String[] args) {

        WalletAccount wallet = new Wallet(100);

        System.out.println("Initial balance: $" + wallet.getBalance());

        try {

            wallet.withdraw(40);

        } catch (InsufficientFundsException e) {

            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("Current balance: $" + wallet.getBalance());

    }

}
