// Bank.java
package bank;
import java.util.List;
import java.util.ArrayList;

// Represents the bank that manages multiple accounts
public class Bank{
    private List<Account> accounts = new ArrayList<>();

    // Create a new account and add it to the list
    public Account createAccount(String name, String pin, double initialDeposit){
        Account acc = new Account(name, pin, initialDeposit);
        accounts.add(acc);
        return acc;
    }

    // Retrieve an account by its ID
    public Account getAccountById(int id){
        for(Account acc : accounts){
            if(acc.getAccountId() == id) return acc;
        }
        return null;
    }

    // Return the list of all accounts
    public List<Account> getAllAccounts(){
        return accounts;
    }
}