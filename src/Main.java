// Main.java (GUI Entry Point)
import bank.Bank;
import ui.LoginFrame;

// Main class that launches the application
public class Main {
    public static void main(String[] args){
        Bank bank = new Bank();
        new LoginFrame(bank);

    }
}