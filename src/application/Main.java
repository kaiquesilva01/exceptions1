package application;

import model.entities.Account;
import model.exception.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f", acc.getBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        sc.close();
    }
}