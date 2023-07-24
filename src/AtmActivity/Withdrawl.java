package AtmActivity;

import internetbankingsystem.DBConnection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;
    String cardNumber;

    Withdrawl(String cardNumber) {
        this.cardNumber = cardNumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Gellary/atmScreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 20);
        l3.add(l1);

        l2.setBounds(190, 400, 400, 20);
        l3.add(l2);

        t1.setBounds(190, 450, 330, 30);
        l3.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                } else {
                    DBConnection c = new DBConnection();
                    java.sql.ResultSet rs = c.s.executeQuery("SELECT * FROM userdetails WHERE cardNumber = '" + cardNumber + "'");
                    if (rs.next()) {
                        long accountNumber = rs.getLong("accountNumber");
                        String name = rs.getString("name");
                        String discription = "Withdraw by ATM";
                        c.s.executeUpdate("UPDATE userdetails SET balance = balance -  '" + amount + "',point = point + 15  WHERE cardNumber = '" + cardNumber + "'");
                        c.s.executeUpdate("INSERT INTO transaction (accountNumber,name,cardNumber, discription, amount) VALUES ('" + accountNumber + "','" + name + "', '" + cardNumber + "', '" + discription + "', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "TK. " + amount + " Withdraw Successfully");
                        setVisible(false);
                        new Transactions(cardNumber).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Withdraw Unsuccessfull");
                    }

                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
            }
        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
