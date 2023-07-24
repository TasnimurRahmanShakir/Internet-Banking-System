package UserActivity;

import internetbankingsystem.DBConnection;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Header extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public Header(long accountNumber) {
        initComponents();
        try {
            DBConnection c = new DBConnection();
            java.sql.ResultSet rs = c.s.executeQuery("SELECT photo FROM userdetails where accountNumber = '"+accountNumber+"'");
            if (rs.next()) {
                String link = rs.getString("photo");
                System.out.println(link);
                URL url = new URL(link);
                Image image = ImageIO.read(url);
                System.out.println(image);
                Image ScalledImage = image.getScaledInstance(170, 190, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(ScalledImage);
                photo.setIcon(icon);
            } else {
                System.out.println("No rows in the result set");
            }
        } catch (SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 170, 190));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel photo;
    // End of variables declaration//GEN-END:variables
}
