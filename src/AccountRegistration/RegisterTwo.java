package AccountRegistration;

import internetbankingsystem.DBConnection;
import internetbankingsystem.FirstPage;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RegisterTwo extends javax.swing.JFrame {

    String formNo;

    public RegisterTwo(String formNo) {
        initComponents();
        this.formNo = formNo;
        ApplicationNo.setText("APPLICATION FORM NO. " + formNo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButton = new javax.swing.ButtonGroup();
        maritalButton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        ApplicationNo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        postCode = new javax.swing.JTextField();
        district = new javax.swing.JTextField();
        division = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        next = new javax.swing.JButton();
        relegion = new javax.swing.JComboBox<>();
        ocupation = new javax.swing.JComboBox<>();
        income = new javax.swing.JComboBox<>();
        education = new javax.swing.JComboBox<>();
        thana = new javax.swing.JTextField();
        house = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(748, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ApplicationNo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        ApplicationNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationNo.setText("APPLICATION FORM NO.");
        jPanel1.add(ApplicationNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 560, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Page 2: Personal Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 340, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ocupation: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 160, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Relegion:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 160, 40));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Edu. Qualification:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 160, 40));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Income:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("District:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 160, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Division:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 160, 40));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Thana:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 160, -1));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("House Adrees:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 160, 40));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Post Code:");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 160, -1));

        postCode.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(postCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 480, 40));

        district.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(district, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 480, 40));

        division.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(division, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 480, 40));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 710, 110, 30));

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 710, 110, 30));

        relegion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        relegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Hindu", "Cristian", "Buddhist", "Other" }));
        jPanel1.add(relegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 480, 40));

        ocupation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ocupation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher", "Employee", "Self-Employee", "Labour", " " }));
        jPanel1.add(ocupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 480, 40));

        income.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        income.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 100,000", "< 250,000", "< 500,000", "< 1,000,000", "> 1,000,000" }));
        jPanel1.add(income, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 480, 40));

        education.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        education.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Non-Education", "JSC", "SSC", "HSC", "Hons.", "Masters" }));
        jPanel1.add(education, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 480, 40));

        thana.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(thana, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 480, 40));

        house.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(house, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 480, 40));

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

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        String relegion = this.relegion.getSelectedItem().toString();
        String ocupation = this.ocupation.getSelectedItem().toString();
        String education = this.education.getSelectedItem().toString();
        String income = this.income.getSelectedItem().toString();
        String adress = "";
        
        if(division.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Your Division.");
            return;
        }
        adress = adress + division.getText() +" ";
        
        if(district.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Your District.");
            return;
        }
        
        adress = adress + district.getText() +" ";
        if(thana.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Your Thana Adress.");
            return;
        }
        
        adress = adress + thana.getText() +" ";
        if(house.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Your House Adress.");
            return;
        }
        
        adress = adress + house.getText() +" ";
        
        String postCode = this.postCode.getText();
        if(postCode.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Your Post-Code.");
            return;
        }
        
        
        try {
            DBConnection c = new DBConnection();
            String q1 = "insert into registertwo values('" + formNo + "','" + relegion + "','" + ocupation + "','" + education + "','" + income + "','" + adress + "','" + postCode + "')";
            c.s.executeUpdate(q1);

        } catch (SQLException e) {

            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dispose();
        new RegisterThree(formNo).setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterTwo("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationNo;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField district;
    private javax.swing.JTextField division;
    private javax.swing.JComboBox<String> education;
    private javax.swing.ButtonGroup genderButton;
    private javax.swing.JTextField house;
    private javax.swing.JComboBox<String> income;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton next;
    private javax.swing.JComboBox<String> ocupation;
    private javax.swing.JTextField postCode;
    private javax.swing.JComboBox<String> relegion;
    private javax.swing.JTextField thana;
    // End of variables declaration//GEN-END:variables
}
