import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Account createAccount(String name, double initialDeposit, int pin) {
        Account acc = new Account(name, initialDeposit, pin);
        accounts.add(acc);
        System.out.println("✅ Account created for " + name + " | ID: " + acc.getId());
        return acc;
    }

    public Account getAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.getId() == id) {
                return acc;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        System.out.println("📄 All Accounts:");
        for (Account acc : accounts) {
            acc.showBalance();
        }
    }
}
