package AtmActivity;

import internetbankingsystem.DBConnection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;

    MiniStatement(String cardNumber) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        double balance = 0;
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("SELECT balance FROM userdetails WHERE cardNumber = '" + cardNumber + "'");
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM transaction WHERE cardNumber = '" + cardNumber + "'");
            if (rs.next()) {
                l3.setText("Card Number:    " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }

        try {
            int i = 0;
            DBConnection c1 = new DBConnection();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM transaction WHERE cardNumber = '" + cardNumber + "'");
            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getTimestamp("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("discription") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (i >= 5) {
                    break;
                }
                i++;

            }
            l4.setText("Your total Balance is Rs " + balance);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

}
