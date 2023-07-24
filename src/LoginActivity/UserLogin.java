package LoginActivity;

import AccountRegistration.RegisterOne;
import internetbankingsystem.DBConnection;
import internetbankingsystem.FirstPage;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserLogin extends javax.swing.JFrame {

    public UserLogin() {
        initComponents();
//        userName.setBackground(new Color(0,0,0,1));
//        password.setBackground(new Color(0,0,0,1));
        show.setVisible(false);
        show.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        remcheckbox = new javax.swing.JCheckBox();
        forgetpasslabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        userName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(25, 118, 221));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 38)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("User Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 598, 57));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 133, 598, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 510, -1));

        jLabel6.setForeground(new java.awt.Color(102, 255, 255));
        jLabel6.setText("______________________________________________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 214, 390, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(199, 226, 255));
        jLabel9.setText("Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 244, -1, -1));

        jLabel10.setForeground(new java.awt.Color(153, 255, 255));
        jLabel10.setText("________________________________________________________");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 294, -1, -1));

        remcheckbox.setBackground(new java.awt.Color(25, 118, 221));
        remcheckbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        remcheckbox.setForeground(new java.awt.Color(199, 226, 255));
        remcheckbox.setText("Remember Password");
        remcheckbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(remcheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 321, -1, -1));

        forgetpasslabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        forgetpasslabel.setForeground(new java.awt.Color(199, 226, 255));
        forgetpasslabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        forgetpasslabel.setText("Forget Password?");
        forgetpasslabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(forgetpasslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 321, 151, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(199, 226, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Don't have an account?");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 441, 290, -1));

        password.setFont(password.getFont().deriveFont(password.getFont().getSize()+4f));
        password.setBorder(null);
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 268, 390, 40));

        userName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel2.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 390, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-close-35.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 40));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 390, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sign Up");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 100, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/user.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 40, 40));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/eye.png"))); // NOI18N
        show.setText("jLabel11");
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 40, 40));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/invisible.png"))); // NOI18N
        hide.setText("jLabel11");
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jPanel2.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 40, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 610, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/bg.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        setSize(new java.awt.Dimension(1124, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        new FirstPage().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        password.setEchoChar((char) 0);
        hide.setVisible(false);
        hide.setEnabled(false);
        show.setVisible(true);
        show.setEnabled(true);
    }//GEN-LAST:event_hideMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        password.setEchoChar((char) 8226);
        hide.setVisible(true);
        hide.setEnabled(true);
        show.setVisible(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DBConnection dbconnect = new DBConnection();
        String userName = this.userName.getText();
        String password = new String(this.password.getPassword());

        if (userName.equals("")) {

            JOptionPane.showMessageDialog(null, "Enter your Username");
            return;
        }
        if (password.equals("")) {

            JOptionPane.showMessageDialog(null, "Enter your Password");
            return;
        }
        try {

            String loginQuery = "SELECT * FROM userdetails WHERE userName='" + userName + "' AND pass='" + password + "'";
            java.sql.ResultSet rs = dbconnect.s.executeQuery(loginQuery);

            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null, "login Successfull");
                dispose();
                new UserActivity.Activity(userName).setVisible(true);
                return;
            }
            JOptionPane.showMessageDialog(null, "login unsuccessfull");

        } catch (SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new RegisterOne().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new UserLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgetpasslabel;
    private javax.swing.JLabel hide;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox remcheckbox;
    private javax.swing.JLabel show;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
