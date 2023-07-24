package AccountRegistration;

import internetbankingsystem.DBConnection;
import java.util.Random;
import internetbankingsystem.FirstPage;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class RegisterOne extends javax.swing.JFrame {

    String link = null;
    String first;

    public RegisterOne() {
        initComponents();

        Random ran = new Random();
        long first4 = (ran.nextLong() % 9000L) + 1000L;
        first = "" + Math.abs(first4);
        formNo.setText("APPLICATION FORM NO. " + first);

    }

    public boolean isValidContactNumber(String contactNumber) {

        String pattern = "01\\d{9}";

        return contactNumber.matches(pattern);
    }

    public class EmailValidator {

        private final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        public boolean isValidEmail(String email) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            return pattern.matcher(email).matches();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButton = new javax.swing.ButtonGroup();
        maritalButton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        formNo = new javax.swing.JLabel();
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
        name = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        nid = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        other = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        dob = new com.toedter.calendar.JDateChooser();
        married = new javax.swing.JRadioButton();
        unmarried = new javax.swing.JRadioButton();
        cancel = new javax.swing.JButton();
        next = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        Load = new javax.swing.JButton();
        ImageLink = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(748, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formNo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        formNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formNo.setText("APPLICATION FORM NO.");
        jPanel1.add(formNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 560, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Page 1: Personal Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 340, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Father's Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 40));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mother's Name:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, 40));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Emai:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Contact Number:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 160, 40));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("NID Number:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 160, -1));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Gender:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 160, 40));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Marital Status:");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 160, -1));

        name.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 390, 40));

        fname.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 390, 40));

        mname.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 390, 40));

        nid.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 390, 40));

        email.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 390, 40));

        contact.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 390, 40));

        other.setBackground(new java.awt.Color(255, 255, 255));
        genderButton.add(other);
        other.setText("Other");
        jPanel1.add(other, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, -1, -1));

        male.setBackground(new java.awt.Color(255, 255, 255));
        genderButton.add(male);
        male.setText("Male");
        jPanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, -1, -1));

        female.setBackground(new java.awt.Color(255, 255, 255));
        genderButton.add(female);
        female.setText("Female");
        jPanel1.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, -1, -1));
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 390, 40));

        married.setBackground(new java.awt.Color(255, 255, 255));
        maritalButton.add(married);
        married.setText("Married");
        jPanel1.add(married, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, -1, -1));

        unmarried.setBackground(new java.awt.Color(255, 255, 255));
        maritalButton.add(unmarried);
        unmarried.setText("Un-Married");
        jPanel1.add(unmarried, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 650, -1, -1));

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

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 158, 170, 190));

        Load.setBackground(new java.awt.Color(0, 102, 102));
        Load.setForeground(new java.awt.Color(255, 255, 255));
        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });
        jPanel1.add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 170, 30));

        ImageLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageLinkActionPerformed(evt);
            }
        });
        jPanel1.add(ImageLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(809, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
        new FirstPage().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed


    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        String name = this.name.getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Name.");
            return;
        }

        String fname = this.fname.getText();
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Father Name.");
            return;
        }

        String mname = this.mname.getText();
        if (mname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Mother Name.");
            return;
        }

        String dob = ((JTextComponent) this.dob.getDateEditor().getUiComponent()).getText();
        if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Birthday.");
            return;
        }

        String contact = this.contact.getText();
        boolean isValid = isValidContactNumber(contact);
        if (contact.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Contact Number.");
            return;
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Please Enter valid Contact Number.");
            return;
        } else {
            try {

                DBConnection c = new DBConnection();
                String q1 = "SELECT contact AS contact FROM userdetails WHERE contact = '" + contact + "' UNION SELECT contact AS contact FROM registerone WHERE contact = '" + contact + "'";
                java.sql.ResultSet rs = c.s.executeQuery(q1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This contact number already taken.Try with new contact number");
                    return;
                }

            } catch (SQLException e) {

                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

        String email = this.email.getText();
        if (!email.equals("")) {
            EmailValidator ev = new EmailValidator();
            boolean isValidemail = ev.isValidEmail(email);
            if (!isValidemail) {
                JOptionPane.showMessageDialog(null, "Please Enter valid Email Number.");
                return;
            } else {
                try {
                    DBConnection c = new DBConnection();
                    String q1 = "SELECT email AS email FROM userdetails WHERE email = '" + email + "' UNION SELECT email AS email FROM registerone WHERE email = '" + email + "'";
                    java.sql.ResultSet rs = c.s.executeQuery(q1);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "This email id already taken.Try with new email id");
                        return;
                    }

                } catch (SQLException e) {

                    String errorMessage = "SQL Exception: " + e.getMessage();
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        String nid = this.nid.getText();
        if (nid.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Birthday.");
            return;
        }

        male.setActionCommand("Male");
        female.setActionCommand("Female");
        other.setActionCommand("Other");
        String gender = genderButton.getSelection().getActionCommand();
        if (gender.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Birthday.");
            return;
        }

        married.setActionCommand("Married");
        unmarried.setActionCommand("Unmarried");
        String maritalStatus = maritalButton.getSelection().getActionCommand();
        if (maritalStatus.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Birthday.");
            return;
        }

        try {

            DBConnection c = new DBConnection();
            String q1 = "insert into registerone values('" + first + "','" + name + "','" + fname + "','" + mname + "','" + dob + "','" + contact + "','" + email + "','" + nid + "','" + gender + "','" + maritalStatus + "','" + link + "'  )";
            c.s.executeUpdate(q1);

        } catch (SQLException e) {

            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();
        new RegisterTwo(first).setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        link = ImageLink.getText();
        try {
            URL url = new URL(link);
            Image image = ImageIO.read(url);
            Image ScalledImage = image.getScaledInstance(170, 190, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(ScalledImage);
            photo.setIcon(icon);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RegisterOne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterOne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_LoadActionPerformed

    private void ImageLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImageLinkActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ImageLink;
    private javax.swing.JButton Load;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField contact;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel formNo;
    private javax.swing.ButtonGroup genderButton;
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
    private javax.swing.JRadioButton male;
    private javax.swing.ButtonGroup maritalButton;
    private javax.swing.JRadioButton married;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField name;
    private javax.swing.JButton next;
    private javax.swing.JTextField nid;
    private javax.swing.JRadioButton other;
    private javax.swing.JLabel photo;
    private javax.swing.JRadioButton unmarried;
    // End of variables declaration//GEN-END:variables
}
