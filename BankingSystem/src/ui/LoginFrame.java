// LoginFrame.java
package ui;
import bank.*;
import javax.swing.*;

// Login GUI for authenticates users or navigation to register
public class LoginFrame extends JFrame{
    public LoginFrame(Bank bank){
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // UI components
        JLabel idLabel = new JLabel("Account ID: ");
        JLabel pinLabel = new JLabel("PIN: ");
        JTextField idField = new JTextField();
        JPasswordField pinField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        // UI components
        idLabel.setBounds(30, 30, 100, 25);
        idField.setBounds(120, 30, 130, 25);
        pinLabel.setBounds(30, 70, 100, 25);
        pinField.setBounds(120, 70, 130, 25);
        loginBtn.setBounds(30, 110, 100, 30);
        registerBtn.setBounds(150, 110, 100, 30);

        // Login action
        loginBtn.addActionListener(e -> {
            try{
                int id = Integer.parseInt(idField.getText());
                String pin = new String(pinField.getPassword());
                Account acc = bank.getAccountById(id);
                if(acc != null && acc.getPin().equals(pin)){
                    new DashboardFrame(acc);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Invalid Credentials");
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Register action
        registerBtn.addActionListener(e -> {
            new RegisterFrame(bank);
            dispose();
        });

        // Add components
        add(idLabel);
        add(pinLabel);
        add(idField);
        add(pinField);
        add(loginBtn);
        add(registerBtn);

        setVisible(true);
    }
}