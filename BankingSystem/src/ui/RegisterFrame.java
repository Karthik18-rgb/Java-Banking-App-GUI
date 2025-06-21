// RegisterFrame.java
package ui;
import bank.*;
import javax.swing.*;
import javax.swing.plaf.PanelUI;

// GUI for creating a new account
public class RegisterFrame extends JFrame{
    public RegisterFrame(Bank bank){
        setTitle("Register account");
        setSize(350,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        JLabel pinLabel = new JLabel("PIN: ");
        JLabel amountLabel = new JLabel("Initial Deposit: ");

        JTextField nameField = new JTextField();
        JPasswordField pinField = new JPasswordField();
        JTextField amountField = new JTextField();

        JButton createBtn = new JButton("Create Account");

        // UI components
        nameLabel.setBounds(30, 30, 100, 25);
        nameField.setBounds(150, 30, 150, 25);
        pinLabel.setBounds(30, 70, 100, 25);
        pinField.setBounds(150, 70, 150, 25);
        amountLabel.setBounds(30, 110, 120, 25);
        amountField.setBounds(150, 110, 150, 25);
        createBtn.setBounds(100, 160, 150, 30);

        // Create account action
        createBtn.addActionListener(e -> {
            try{
                String name = nameField.getText();
                String pin = new String(pinField.getPassword());
                double deposit = Double.parseDouble(amountField.getText());
                Account newAcc = bank.createAccount(name, pin, deposit);
                JOptionPane.showMessageDialog(this, "Account created! Your account ID is: " + newAcc.getAccountId());
                new LoginFrame(bank);
                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Add components
        add(nameLabel);
        add(nameField);
        add(pinLabel);
        add(pinField);
        add(amountLabel);
        add(amountField);
        add(createBtn);

        setVisible(true);
    }
}