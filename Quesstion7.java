//*
Write a java program for bank details using multilevel inheritance for the variables such as to get accno,
name, age, gender, acctype, total and display the balance, withdraw, deposit and annual interest.



*//
  Write a java program for bank details using multilevel inheritance for the variables such as to get accno,
name, age, gender, acctype, total and display the balance, withdraw, deposit and annual interest.
Ans: 
import java.util.Scanner;

class Account {
    int accNo;
    String name;
    int age;
    String gender;
    String accType;
    double balance;

    void getAccountDetails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account number: ");
        accNo = input.nextInt();
        input.nextLine();

        System.out.print("Enter account holder name: ");
        name = input.nextLine();

        System.out.print("Enter account holder age: ");
        age = input.nextInt();
        input.nextLine();

        System.out.print("Enter account holder gender: ");
        gender = input.nextLine();

        System.out.print("Enter account type (Savings/Current): ");
        accType = input.nextLine();

        System.out.print("Enter initial balance: ");
        balance = input.nextDouble();
    }

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance. Withdrawal not possible.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    double calculateInterest() {
        return 0;
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount() {
        interestRate = 0.05;
    }

    double calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest earned: " + interest);
        return interest;
    }
}

class CurrentAccount extends Account {
    double minimumBalance;

    CurrentAccount() {
        minimumBalance = 5000;
    }

    void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal not possible. Minimum balance of " + minimumBalance + " should be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }
}

public class BankDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account type (Savings/Current): ");
        String accType = input.nextLine();

        Account acc;

        if (accType.equalsIgnoreCase("Savings")) {
            acc = new SavingsAccount();
        } else {
            acc = new CurrentAccount();
        }

        acc.getAccountDetails();

        System.out.print("Enter amount to be deposited: ");
        double amount = input.nextDouble();
        acc.deposit(amount);

        System.out.print("Enter amount to be withdrawn: ");
        amount = input.nextDouble();
        acc.withdraw(amount);

        acc.calculateInterest();

        acc.displayBalance();
    }
}



