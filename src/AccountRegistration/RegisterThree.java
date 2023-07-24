package AccountRegistration;

import internetbankingsystem.DBConnection;
import internetbankingsystem.FirstPage;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

public class RegisterThree extends javax.swing.JFrame {

    String formNo, cardNumber, pinNumber;

    public RegisterThree(String formNo) {
        initComponents();
        ApplicationNo.setText("APPLICATION FORM NO. " + formNo);

        this.formNo = formNo;
        cardDemo.setText(" XXXX-XXXX-XXXX-4184");
        pinDemo.setText(" XXXX");

        Random ran = new Random();
        long card = (ran.nextLong() % 90000000L) + 5040936000000000L;
        cardNumber = "" + Math.abs(card);

        long pin = (ran.nextLong() % 9000L) + 1000L;
        pinNumber = "" + Math.abs(pin);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButton = new javax.swing.ButtonGroup();
        maritalButton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ApplicationNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        sservice = new javax.swing.JCheckBox();
        atm = new javax.swing.JCheckBox();
        mbanking = new javax.swing.JCheckBox();
        estatement = new javax.swing.JCheckBox();
        eservice = new javax.swing.JCheckBox();
        cheque = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cardDemo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pinDemo = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        must = new javax.swing.JCheckBox();
        catagory = new javax.swing.JComboBox<>();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(748, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Page 2: Personal Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 340, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Services:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 160, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Account Type:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 160, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(748, 800));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ApplicationNo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        ApplicationNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationNo.setText("APPLICATION FORM NO.");
        jPanel4.add(ApplicationNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 560, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Page 2: Personal Details");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 340, 20));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Services:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 160, 40));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Account Type:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 160, 40));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel4.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 740, 110, 30));

        sservice.setBackground(new java.awt.Color(255, 255, 255));
        sservice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sservice.setText("SMS Service");
        jPanel4.add(sservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 110, -1));

        atm.setBackground(new java.awt.Color(255, 255, 255));
        atm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        atm.setText("ATM Card");
        jPanel4.add(atm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 110, -1));

        mbanking.setBackground(new java.awt.Color(255, 255, 255));
        mbanking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mbanking.setText("Mobile Banking");
        jPanel4.add(mbanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 130, -1));

        estatement.setBackground(new java.awt.Color(255, 255, 255));
        estatement.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estatement.setText("E-Statement");
        jPanel4.add(estatement, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 130, -1));

        eservice.setBackground(new java.awt.Color(255, 255, 255));
        eservice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eservice.setText("Email Service");
        jPanel4.add(eservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 120, -1));

        cheque.setBackground(new java.awt.Color(255, 255, 255));
        cheque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cheque.setText("Cheque");
        jPanel4.add(cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 130, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Username:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 160, 40));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Password:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 160, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Your 16-digit Card number");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 260, 20));

        cardDemo.setEditable(false);
        cardDemo.setBackground(new java.awt.Color(255, 255, 255));
        cardDemo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cardDemo.setBorder(null);
        jPanel4.add(cardDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 480, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("4-digit password");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 260, 20));

        pinDemo.setEditable(false);
        pinDemo.setBackground(new java.awt.Color(255, 255, 255));
        pinDemo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pinDemo.setBorder(null);
        jPanel4.add(pinDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 480, 40));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Card Number:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 160, 40));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("PIN Number:");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 160, -1));

        userName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel4.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 480, 40));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel4.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 740, 110, 30));

        must.setBackground(new java.awt.Color(255, 255, 255));
        must.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        must.setText("I hereby declares that the above entered details correct to th best of my knowledge.");
        jPanel4.add(must, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 700, -1, -1));

        catagory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        catagory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Studen Account", "Saving Account", "Current Account", "Salary Account", "Corporate Account" }));
        jPanel4.add(catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 480, 40));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-eye-35.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel4.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, 40, 40));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-invisible-35.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jPanel4.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, 40, 40));

        password.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel4.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 440, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(748, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
        new FirstPage().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String catagory = this.catagory.getSelectedItem().toString();

        String services = "";
        if (atm.isSelected()) {
            services = services + atm.getText() + " ";
        }
        if (mbanking.isSelected()) {
            services = services + mbanking.getText() + " ";
        }
        if (sservice.isSelected()) {
            services = services + sservice.getText() + " ";
        }
        if (eservice.isSelected()) {
            services = services + eservice.getText() + " ";
        }
        if (cheque.isSelected()) {
            services = services + cheque.getText() + " ";
        }
        if (estatement.isSelected()) {
            services = services + estatement.getText() + " ";
        }

        String userName = this.userName.getText();
        if (userName.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Username.");
            return;
        } else {
            try {
                DBConnection c = new DBConnection();
                String q1 = "SELECT userName AS userName FROM userdetails WHERE userName = '"+userName+"' UNION SELECT userName AS userName FROM registerthree WHERE userName = '"+userName+"'";
                java.sql.ResultSet rs = c.s.executeQuery(q1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This username already taken.Try with new username");
                    return;
                }

            } catch (SQLException e) {

                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

        String password = new String(this.password.getPassword());
        if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter password.");
            return;
        }

        if (!must.isSelected()) {
            JOptionPane.showMessageDialog(null, "Check the checkbox");
            return;
        }

        try {
            DBConnection c = new DBConnection();
            String q1 = "insert into registerthree values('" + formNo + "','" + catagory + "','" + services + "','" + cardNumber + "','" + pinNumber + "','" + userName + "','" + password + "')";
            c.s.executeUpdate(q1);

        } catch (SQLException e) {

            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dispose();

    }//GEN-LAST:event_submitActionPerformed

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked

        show.setVisible(true);
        hide.setVisible(false);
        password.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        // TODO add your handling code here:
        show.setVisible(false);
        hide.setVisible(true);
        password.setEchoChar('*');
    }//GEN-LAST:event_showMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterThree("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationNo;
    private javax.swing.JCheckBox atm;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField cardDemo;
    private javax.swing.JComboBox<String> catagory;
    private javax.swing.JCheckBox cheque;
    private javax.swing.JCheckBox eservice;
    private javax.swing.JCheckBox estatement;
    private javax.swing.ButtonGroup genderButton;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.ButtonGroup maritalButton;
    private javax.swing.JCheckBox mbanking;
    private javax.swing.JCheckBox must;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField pinDemo;
    private javax.swing.JLabel show;
    private javax.swing.JCheckBox sservice;
    private javax.swing.JButton submit;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
