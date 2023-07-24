package AtmActivity;

import internetbankingsystem.DBConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String cardNumber;

    Pin(String cardNumber) {
        this.cardNumber = cardNumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Gellary/atmScreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(280, 330, 800, 35);
        l4.add(l1);

        l2.setBounds(180, 390, 150, 35);
        l4.add(l2);

        l3.setBounds(180, 440, 200, 35);
        l4.add(l3);

        t1.setBounds(350, 390, 180, 25);
        l4.add(t1);

        t2.setBounds(350, 440, 180, 25);
        l4.add(t2);

        b1.setBounds(390, 588, 150, 35);
        l4.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l4.add(b2);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = t1.getText();
            String rpin = t2.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                DBConnection c = new DBConnection();
                String q1 = "update userdetails set pinNumber = '" + rpin + "' where cardNumber = '" + cardNumber + "' ";

                c.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } else if (ae.getSource() == b2) {
                new Transactions(cardNumber).setVisible(true);
                setVisible(false);
            }
        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
