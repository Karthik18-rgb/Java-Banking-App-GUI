// Account.java
package bank;
import java.util.List;
import java.util.ArrayList;

// Represents a bank account with basic operations
public class Account{
    private static int counter = 1001;
    private int accountId;
    private String name;
    private String pin;
    private double balance;
    private List<String> transactions;

    // Constructor to initialize account
    public Account(String name, String pin, double balance){
        this.accountId = counter++;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        addTransaction("Account created with balance: " + balance);
    }

    // Deposit money into account
    public void deposit(double amount){
        balance += amount;
        addTransaction("Deposited: " + amount);
    }

    // Withdraw money from account if sufficient balance
    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            addTransaction("Withdrew: " + amount);
        }
        else{
            addTransaction("Failed to withdeaw " + amount + "(insufficient funds)");
        }
    }

    // Add a transaction log with timestamp
    public void addTransaction(String log){
        transactions.add(java.time.LocalDate.now() + " - " + log);
    }

    // Get all transaction logs
    public List<String> getTransactions(){
        return transactions;
    }

    // Getters
    public int getAccountId(){
        return accountId;
    }
    public String getName(){
        return name;
    }
    public String getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
}