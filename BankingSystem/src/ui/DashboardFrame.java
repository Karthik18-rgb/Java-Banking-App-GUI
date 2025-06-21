// DashboardFrame.java
package ui;

import bank.Account;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class DashboardFrame extends JFrame {
    public DashboardFrame(Account account) {
        setTitle("Dashboard - " + account.getName());
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // UI Components
        JLabel welcome = new JLabel("Welcome, " + account.getName());
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Check Balance");
        JButton txBtn = new JButton("Transaction History");
        JButton pdfBtn = new JButton("Export to PDF");
        JButton analysisBtn = new JButton("Spending Analysis");

        // Deposit action
        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter deposit amount:");
            try {
                double amount = Double.parseDouble(input);
                if (amount <= 0) throw new Exception();
                account.deposit(amount);
                JOptionPane.showMessageDialog(null, "₹" + amount + " deposited successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });

        // Withdraw action
        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
            try {
                double amount = Double.parseDouble(input);
                if (amount <= 0) throw new Exception();
                if (amount > account.getBalance()) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                } else {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(null, "₹" + amount + " withdrawn successfully.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });

        // Show balance
        balanceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Balance: ₹" + account.getBalance());
        });

        // Transaction history
        txBtn.addActionListener(e -> new TransactionFrame(account));

        // Export to PDF
        pdfBtn.addActionListener(e -> exportPDF(account));


        // Add all components
        add(welcome);
        add(depositBtn);
        add(withdrawBtn);
        add(balanceBtn);
        add(txBtn);
        add(pdfBtn);
        add(analysisBtn);

        setVisible(true);
    }

    // PDF export logic
    private void exportPDF(Account account) {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);

            // Use a ₹ compatible font
            PDType0Font font = PDType0Font.load(doc, new File("C:/Windows/Fonts/arial.ttf"));

            content.beginText();
            content.setFont(font, 18);
            content.setLeading(22.5f);
            content.newLineAtOffset(50, 750);
            content.showText("Bank Statement");
            content.newLine();
            content.setFont(font, 12);
            content.showText("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            content.newLine();
            content.showText("Account ID: " + account.getAccountId());
            content.newLine();
            content.showText("Name: " + account.getName());
            content.newLine();
            content.showText("Balance: ₹" + account.getBalance());
            content.newLine();
            content.newLine();
            content.showText("Transaction History:");
            content.newLine();

            List<String> txList = account.getTransactions();
            for (String tx : txList) {
                content.showText(tx);
                content.newLine();
            }

            content.endText();
            content.close();

            File dir = new File("output");
            if (!dir.exists()) dir.mkdirs();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File file = new File(dir, "account_" + account.getAccountId() + "_" + timestamp + ".pdf");
            doc.save(file);

            JOptionPane.showMessageDialog(null, "PDF exported to:\n" + file.getAbsolutePath());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "PDF Export failed: " + ex.getMessage());
        }
    }
}
