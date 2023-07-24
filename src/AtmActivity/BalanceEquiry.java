package AtmActivity;

import internetbankingsystem.DBConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JButton b1;
    JLabel l1;
    String cardNumber;

    BalanceEnquiry(String cardNumber) {
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/Gellary/atmScreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);
        double balance = 0;
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("SELECT balance FROM userdetails WHERE cardNumber = '" + cardNumber + "'");
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
            else{
                JOptionPane.showMessageDialog(null, "Connection problem.");
            }
        } catch (NumberFormatException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }

        l1.setText("Your Current Account Balance is Tk. " + balance);

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(cardNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
