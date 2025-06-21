// TransactionFrame.java
package ui;
import bank.Account;
import javax.swing.*;

// Shows transaction history in a separate window
public class TransactionFrame extends JFrame {
    public TransactionFrame(Account account){
        setTitle("Transaction history: " + account.getName());
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea area = new JTextArea();
        for(String tx : account.getTransactions()){
            area.append(tx + "\n");
        }
        area.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(area);
        add(scrollPane);
        setVisible(true);
    }
}

