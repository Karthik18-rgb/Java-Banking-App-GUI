import java.util.ArrayList;
import java.util.List;

public class Account {
    private static int nextId = 1;
    private int id;
    private String name;
    private double balance;
    private int pin;
    private List<String> transactions;

    public Account(String name, double initialDeposit, int pin) {
        this.id = nextId++;
        this.name = name;
        this.balance = initialDeposit;
        this.pin = pin;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with ₹" + initialDeposit);
    }

    public int getId() {
        return id;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited ₹" + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    public void showBalance() {
        System.out.println("Account ID: " + id + ", Name: " + name + ", Balance: ₹" + balance);
    }

    public void showTransactions() {
        System.out.println("Transaction history for Account ID: " + id);
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }

    public String getName() {
        return name;
    }
}
