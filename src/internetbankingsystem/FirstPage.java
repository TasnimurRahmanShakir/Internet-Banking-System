package internetbankingsystem;


import AccountRegistration.RegisterOne;
import LoginActivity.AdminLogin;
import LoginActivity.AtmLogin;
import LoginActivity.UserLogin;
import java.awt.Color;

public class FirstPage extends javax.swing.JFrame {

    public FirstPage() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bankLogo = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        atm = new javax.swing.JLabel();
        userLogin = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bankLogo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        bankLogo.setForeground(new java.awt.Color(255, 255, 255));
        bankLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bankLogo.setText("Bank logo");
        jPanel1.add(bankLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 80));

        register.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("Register");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 110, 40));

        admin.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setText("Admin");
        admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminMouseExited(evt);
            }
        });
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 110, 40));

        atm.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        atm.setForeground(new java.awt.Color(255, 255, 255));
        atm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atm.setText("ATM");
        atm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atmMouseExited(evt);
            }
        });
        jPanel1.add(atm, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 110, 40));

        userLogin.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        userLogin.setForeground(new java.awt.Color(255, 255, 255));
        userLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLogin.setText("User Login");
        userLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userLoginMouseExited(evt);
            }
        });
        jPanel1.add(userLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 40));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-close-35.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 5, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/Bank_Image.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 650));

        setSize(new java.awt.Dimension(1080, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked

        dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void atmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmMouseEntered
        atm.setForeground(Color.GREEN);
    }//GEN-LAST:event_atmMouseEntered

    private void atmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmMouseExited
        if (!atm.isFocusOwner()) {
            atm.setForeground(Color.WHITE); // Restore the original foreground color
        }
    }//GEN-LAST:event_atmMouseExited

    private void adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseEntered
        // TODO add your handling code here:
        admin.setForeground(Color.GREEN);
    }//GEN-LAST:event_adminMouseEntered

    private void adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseExited
        // TODO add your handling code here:
        if (!admin.isFocusOwner()) {
            admin.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_adminMouseExited

    private void userLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginMouseEntered
        // TODO add your handling code here:
        userLogin.setForeground(Color.GREEN);
    }//GEN-LAST:event_userLoginMouseEntered

    private void userLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginMouseExited
        userLogin.setForeground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_userLoginMouseExited

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        // TODO add your handling code here:
        register.setForeground(Color.WHITE);
    }//GEN-LAST:event_registerMouseExited

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        // TODO add your handling code here:
        register.setBackground(null);
        register.setForeground(Color.GREEN);
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:
       dispose();
       new RegisterOne().setVisible(true);
    }//GEN-LAST:event_registerMouseClicked

    private void adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseClicked
        dispose();
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_adminMouseClicked

    private void atmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmMouseClicked
        dispose();
        new AtmLogin().setVisible(true);
    }//GEN-LAST:event_atmMouseClicked

    private void userLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginMouseClicked
        dispose();
        new UserLogin().setVisible(true);
    }//GEN-LAST:event_userLoginMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstPage().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JLabel atm;
    private javax.swing.JLabel bankLogo;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel register;
    private javax.swing.JLabel userLogin;
    // End of variables declaration//GEN-END:variables
}
