package UserActivity;

import internetbankingsystem.DBConnection;
import internetbankingsystem.FirstPage;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Random;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Activity extends javax.swing.JFrame {

    private final DrawerController drawer;

    java.sql.ResultSet rs1;
    java.sql.ResultSet rs2;
    public long accountNumber;
    String AcName;

    public Activity(String userName) {
        initComponents();
        welcome.setText(" Welcome, " + userName);
        int pnt = 0;
        try {
            DBConnection c = new DBConnection();
            String q = "SELECT point FROM userdetails WHERE userName = '" + userName + "'";
            rs1 = c.s.executeQuery(q);
            if (rs1.next()) {
                pnt = rs1.getInt("point");
            }
            if (pnt <= 100) {
                rank.setText("Bronze");
                this.point.setText(pnt + " /100");
                RewardIcon.setIcon(new ImageIcon(getClass().getResource("/Gellary/icons8-bronze-medal-35.png")));
            } else if (pnt <= 500) {
                rank.setText("Silver");
                this.point.setText(pnt + " /500");
                RewardIcon.setIcon(new ImageIcon(getClass().getResource("/Gellary/icons8-silver-medal-35.png")));
            } else if (pnt <= 1000) {
                rank.setText("Gold");
                this.point.setText(pnt + " /1000");
                RewardIcon.setIcon(new ImageIcon(getClass().getResource("/Gellary/icons8-gold-medal-35.png")));
            } else if (pnt <= 2500) {
                rank.setText("Platinium");
                this.point.setText(pnt + " /2500");
                RewardIcon.setIcon(new ImageIcon(getClass().getResource("/Gellary/icons8-p-35.png")));
            }else {
                rank.setText("Diamond");
                this.point.setText(pnt + " /∞");
                RewardIcon.setIcon(new ImageIcon(getClass().getResource("/Gellary/icons8-diamond-35.png")));
            }
        } catch (SQLException e) {
        }

        try {
            DBConnection c = new DBConnection();
            String q = "SELECT * FROM userdetails WHERE userName = '" + userName + "'";
            rs1 = c.s.executeQuery(q);
            if (rs1.next()) {
                accountNumber = rs1.getLong("accountNumber");
                AcName = rs1.getString("name");

            }
        } catch (SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }

        drawer = Drawer.newDrawer(this)
                .header(new Header(accountNumber))
                .headerHeight(280)
                .separator(2, new Color(90, 90, 90))
                .space(5)
                .drawerWidth(300)
                .addChild(new DrawerItem("Home").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-home-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Personal Information").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-user-details-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Account Information").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-contact-details-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Services").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-facilities-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Transaction History").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-history-35.png"))).build())
                .space(7)
                .addFooter(new DrawerItem("Log Out").icon(new ImageIcon(getClass().getResource("/Gellary/exitbutton.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                        System.out.println(index);
                        if (index == 0) {
                            Tab.setSelectedIndex(0);
                            drawer.hide();
                        }

                        if (index == 1) {
                            Tab.setSelectedIndex(1);

                            DBConnection c = new DBConnection();
                            try {
                                String q = "SELECT * FROM userdetails WHERE accountNumber = '" + accountNumber + "'";
                                setRs1(c.s.executeQuery(q));
                                if (getRs1().next()) {
                                    name.setText(getRs1().getString("name"));
                                    fname.setText(getRs1().getString("fname"));
                                    mname.setText(getRs1().getString("mname"));
                                    dob.setText(getRs1().getString("dob"));
                                    contact.setText(getRs1().getString("contact"));
                                    email.setText(getRs1().getString("email"));
                                    nid.setText(getRs1().getString("nid"));
                                    gender.setText(getRs1().getString("gender"));
                                    maritalStatus.setText(getRs1().getString("maritalStatus"));
                                    relegion.setText(getRs1().getString("relegion"));
                                    eduction.setText(getRs1().getString("education"));
                                    ocupation.setText(getRs1().getString("ocupation"));
                                    income.setText(getRs1().getString("income"));
                                    adress.setText(getRs1().getString("adress"));
                                    postCode.setText(getRs1().getString("postCode"));
                                    catagory.setText(getRs1().getString("catagory"));
                                    services.setText(getRs1().getString("services"));

                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            drawer.hide();
                            

                        }

                        //Account details
                        if (index == 2) {
                            Tab.setSelectedIndex(2);
                            DBConnection c = new DBConnection();
                            try {
                                String q = "SELECT * FROM userdetails WHERE accountNumber = '" + accountNumber + "'";
                                rs2 = c.s.executeQuery(q);
                                if (rs2.next()) {
                                    AcNumber.setText(String.valueOf(accountNumber));
                                    cardNumber.setText(rs2.getString("cardNumber"));
                                    double balance;
                                    balance = rs2.getDouble("balance");
                                    amount.setText(String.valueOf(balance) + " TK");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cannot find aany Information");
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

                            }
                            drawer.hide();
                        }

                        //Services
                        if (index == 3) {
                            Tab.setSelectedIndex(3);
                            drawer.hide();
                        }

                        //Transaction History
                        if (index == 4) {
                            Tab.setSelectedIndex(4);
                            DBConnection c = new DBConnection();

                            DefaultTableModel TBModel = (DefaultTableModel) transactionTable.getModel();

                            TBModel.setRowCount(0);
                            try {
                                String q = "SELECT * FROM transaction WHERE accountNumber = '" + accountNumber + "'";
                                setRs1(c.s.executeQuery(q));
                                int i = 0;
                                while (getRs1().next()) {
                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(getRs1().getLong("accountNumber"), i, 0);
                                    TBModel.setValueAt(getRs1().getString("date"), i, 1);
                                    TBModel.setValueAt(getRs1().getString("cardNumber"), i, 2);
                                    TBModel.setValueAt(getRs1().getLong("toAccount"), i, 3);
                                    TBModel.setValueAt(getRs1().getString("discription"), i, 4);
                                    TBModel.setValueAt(getRs1().getDouble("amount"), i, 5);
                                    i++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            drawer.hide();
                        }

                        if (index == 5) {
                            JOptionPane.showMessageDialog(null, "Logout Successfully");
                            dispose();
                            new FirstPage().setVisible(true);
                        }

                    }

                })
                .build();

    }

    public void getValue() {
        DBConnection c = new DBConnection();
        try {
            long acnumber = Long.parseLong(receiverAccount.getText());
            if (accountNumber == acnumber) {
                JOptionPane.showMessageDialog(null, "This is your account. Enter different account");
                return;
            }
            setRs1(c.s.executeQuery("SELECT name FROM userdetails WHERE accountNumber = '" + acnumber + "'"));
            if (getRs1().next()) {
                holderName.setText(getRs1().getString("name"));
            } else {
                JOptionPane.showMessageDialog(null, "Account does't exist.");
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {

            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationPanel = new javax.swing.JPanel();
        menuIcon = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        RewardIcon = new javax.swing.JLabel();
        rank = new javax.swing.JLabel();
        point = new javax.swing.JLabel();
        Tab = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        personalDetails = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        relegion1 = new javax.swing.JTextField();
        relegion = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        maritalStatus = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nid = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        eduction = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        income = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        adress = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        postCode = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        catagory = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        services = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        ocupation = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        accountDetails = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        AcNumber = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cardNumber = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        amount = new javax.swing.JTextField();
        servicePage = new javax.swing.JPanel();
        withdraw = new javax.swing.JButton();
        atmOtp = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        topUp = new javax.swing.JButton();
        fundTransfer = new javax.swing.JButton();
        billPay = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        SubTab = new javax.swing.JTabbedPane();
        getOtp = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel30 = new javax.swing.JPanel();
        otpAmount = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        otpSubmit = new javax.swing.JButton();
        getDeposit = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        depositSubmit = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        depositAmount = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        getWithdraw = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        withdrawSubmit = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        withdrawAmount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        getPayBill = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        getFundTransfer = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        holderName = new javax.swing.JTextField();
        receiverAccount = new javax.swing.JTextField();
        transferSubmit = new javax.swing.JButton();
        transferAmount = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        getTopup = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel39 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        transactionHistory = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navigationPanel.setBackground(new java.awt.Color(0, 102, 102));
        navigationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-menu-50.png"))); // NOI18N
        menuIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconMouseClicked(evt);
            }
        });
        navigationPanel.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 50));

        welcome.setBackground(new java.awt.Color(255, 255, 255));
        welcome.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-male-user-35.png"))); // NOI18N
        welcome.setAutoscrolls(true);
        navigationPanel.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 17, 370, 50));

        RewardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navigationPanel.add(RewardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 40, 40));

        rank.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rank.setForeground(new java.awt.Color(255, 255, 255));
        rank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navigationPanel.add(rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 110, 20));

        point.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        point.setForeground(new java.awt.Color(255, 255, 255));
        point.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navigationPanel.add(point, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 110, 20));

        getContentPane().add(navigationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 80));

        Tab.addTab("tab2", home);

        personalDetails.setBackground(new java.awt.Color(255, 255, 255));
        personalDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setText("Relegion");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        relegion1.setEditable(false);
        relegion1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        relegion1.setBorder(null);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(relegion1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(relegion1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        personalDetails.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, 40));

        relegion.setEditable(false);
        relegion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        relegion.setBorder(null);
        personalDetails.add(relegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 300, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Marital Status");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 160, 40));

        maritalStatus.setEditable(false);
        maritalStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        maritalStatus.setBorder(null);
        personalDetails.add(maritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 300, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Gender");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 40));

        gender.setEditable(false);
        gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        gender.setBorder(null);
        personalDetails.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 300, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("NID Number");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 40));

        nid.setEditable(false);
        nid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nid.setBorder(null);
        personalDetails.add(nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 300, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Contact Number");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 40));

        contact.setEditable(false);
        contact.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        contact.setBorder(null);
        personalDetails.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 300, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Email");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 160, 40));

        email.setEditable(false);
        email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email.setBorder(null);
        personalDetails.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 300, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Date of Birth:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 40));

        dob.setEditable(false);
        dob.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dob.setBorder(null);
        personalDetails.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 300, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Mother's Name::");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 160, 40));

        mname.setEditable(false);
        mname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mname.setBorder(null);
        personalDetails.add(mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Father's Name:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 40));

        fname.setEditable(false);
        fname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fname.setBorder(null);
        personalDetails.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 300, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Name:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, 40));

        name.setEditable(false);
        name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        name.setBorder(null);
        personalDetails.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 300, 40));

        eduction.setEditable(false);
        eduction.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        eduction.setBorder(null);
        personalDetails.add(eduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 300, 40));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel26.setText("Edu. Qualification");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 160, 40));

        income.setEditable(false);
        income.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        income.setBorder(null);
        personalDetails.add(income, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 300, 40));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setText("Income");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, 40));

        adress.setEditable(false);
        adress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adress.setBorder(null);
        personalDetails.add(adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 300, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("Adress");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, 40));

        postCode.setEditable(false);
        postCode.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        postCode.setBorder(null);
        personalDetails.add(postCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 300, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("Post Code");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, 40));

        catagory.setEditable(false);
        catagory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        catagory.setBorder(null);
        personalDetails.add(catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 300, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Account Type");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 160, 40));

        services.setEditable(false);
        services.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        services.setBorder(null);
        personalDetails.add(services, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 300, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Services");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, 40));

        ocupation.setEditable(false);
        ocupation.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ocupation.setBorder(null);
        personalDetails.add(ocupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 300, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("Ocupation");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        personalDetails.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, 40));

        Tab.addTab("tab3", personalDetails);

        accountDetails.setBackground(new java.awt.Color(255, 255, 255));
        accountDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI Semilight", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AcNumber.setEditable(false);
        AcNumber.setBackground(new java.awt.Color(0, 102, 102));
        AcNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcNumber.setForeground(new java.awt.Color(255, 255, 255));
        AcNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AcNumber.setBorder(null);
        jPanel1.add(AcNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 81, 220, 40));

        accountDetails.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 320, 150));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Card Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI Semilight", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardNumber.setEditable(false);
        cardNumber.setBackground(new java.awt.Color(0, 102, 102));
        cardNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cardNumber.setForeground(new java.awt.Color(255, 255, 255));
        cardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cardNumber.setBorder(null);
        jPanel2.add(cardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 82, 220, 40));

        accountDetails.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 320, 150));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI Semilight", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        amount.setEditable(false);
        amount.setBackground(new java.awt.Color(0, 102, 102));
        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount.setBorder(null);
        jPanel3.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 77, 220, 40));

        accountDetails.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 320, 150));

        Tab.addTab("tab1", accountDetails);

        servicePage.setBackground(new java.awt.Color(255, 255, 255));
        servicePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        withdraw.setBackground(new java.awt.Color(0, 153, 153));
        withdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-receive-dollar-100.png"))); // NOI18N
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });
        servicePage.add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 160, 140));

        atmOtp.setBackground(new java.awt.Color(0, 153, 153));
        atmOtp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-atm-100.png"))); // NOI18N
        atmOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atmOtpActionPerformed(evt);
            }
        });
        servicePage.add(atmOtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 160, 140));

        deposit.setBackground(new java.awt.Color(0, 153, 153));
        deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-add-money-100.png"))); // NOI18N
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });
        servicePage.add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 160, 140));

        topUp.setBackground(new java.awt.Color(0, 153, 153));
        topUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-sim-100.png"))); // NOI18N
        topUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpActionPerformed(evt);
            }
        });
        servicePage.add(topUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 160, 140));

        fundTransfer.setBackground(new java.awt.Color(0, 153, 153));
        fundTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-transfer-100.png"))); // NOI18N
        fundTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fundTransferActionPerformed(evt);
            }
        });
        servicePage.add(fundTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 160, 140));

        billPay.setBackground(new java.awt.Color(0, 153, 153));
        billPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-paid-bill-stamp-100.png"))); // NOI18N
        billPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billPayActionPerformed(evt);
            }
        });
        servicePage.add(billPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 160, 140));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setForeground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Withdraw");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 160, 40));

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));
        jPanel11.setForeground(new java.awt.Color(0, 102, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OTP");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 160, 40));

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setForeground(new java.awt.Color(0, 102, 102));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Deposit");
        jPanel17.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 160, 40));

        jPanel22.setBackground(new java.awt.Color(0, 102, 102));
        jPanel22.setForeground(new java.awt.Color(0, 102, 102));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Pay-Bill");
        jPanel22.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, 40));

        jPanel23.setBackground(new java.awt.Color(0, 102, 102));
        jPanel23.setForeground(new java.awt.Color(0, 102, 102));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fund-Transfer");
        jPanel23.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 160, 40));

        jPanel25.setBackground(new java.awt.Color(0, 102, 102));
        jPanel25.setForeground(new java.awt.Color(0, 102, 102));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Top-Up");
        jPanel25.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        servicePage.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 160, 40));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 51, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("If you have Registerd  ATM CARD , then you can withdraw\n  money only from bank's own ATM Booth by receiving \n\t         OTP from here.\n");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel28.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 510, 130));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createMatteBorder(50, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        otpAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        jPanel30.add(otpAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, 60));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Enter your amount");
        jPanel30.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, 30));

        jPanel28.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 360, 160));

        otpSubmit.setBackground(new java.awt.Color(0, 102, 102));
        otpSubmit.setForeground(new java.awt.Color(255, 255, 255));
        otpSubmit.setText("Get OTP");
        otpSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpSubmitActionPerformed(evt);
            }
        });
        jPanel28.add(otpSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 120, 30));

        javax.swing.GroupLayout getOtpLayout = new javax.swing.GroupLayout(getOtp);
        getOtp.setLayout(getOtpLayout);
        getOtpLayout.setHorizontalGroup(
            getOtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getOtpLayout.setVerticalGroup(
            getOtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SubTab.addTab("tab1", getOtp);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        depositSubmit.setBackground(new java.awt.Color(0, 102, 102));
        depositSubmit.setForeground(new java.awt.Color(255, 255, 255));
        depositSubmit.setText("Get OTP");
        depositSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositSubmitActionPerformed(evt);
            }
        });
        jPanel29.add(depositSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 120, 30));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(50, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        depositAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        jPanel31.add(depositAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, 60));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Enter your amount");
        jPanel31.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, 30));

        jPanel29.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 360, 160));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 51, 0));
        jTextArea2.setRows(5);
        jTextArea2.setText("    Enter your amount which amount do you want to \n                         Deposit from Bank Agent.. ");
        jScrollPane2.setViewportView(jTextArea2);

        jPanel29.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 510, 130));

        javax.swing.GroupLayout getDepositLayout = new javax.swing.GroupLayout(getDeposit);
        getDeposit.setLayout(getDepositLayout);
        getDepositLayout.setHorizontalGroup(
            getDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getDepositLayout.setVerticalGroup(
            getDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SubTab.addTab("tab2", getDeposit);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        withdrawSubmit.setBackground(new java.awt.Color(0, 102, 102));
        withdrawSubmit.setForeground(new java.awt.Color(255, 255, 255));
        withdrawSubmit.setText("Get OTP");
        withdrawSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawSubmitActionPerformed(evt);
            }
        });
        jPanel32.add(withdrawSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 120, 30));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createMatteBorder(50, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        withdrawAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        jPanel33.add(withdrawAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, 60));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Enter your amount");
        jPanel33.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, 30));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 360, 160));

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(255, 51, 0));
        jTextArea3.setRows(5);
        jTextArea3.setText("    Enter your amount which amount do you want to \n                         withdraw from Bank Agent..");
        jScrollPane3.setViewportView(jTextArea3);

        jPanel32.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 510, 130));

        javax.swing.GroupLayout getWithdrawLayout = new javax.swing.GroupLayout(getWithdraw);
        getWithdraw.setLayout(getWithdrawLayout);
        getWithdrawLayout.setHorizontalGroup(
            getWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getWithdrawLayout.setVerticalGroup(
            getWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SubTab.addTab("tab3", getWithdraw);

        getPayBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(255, 51, 0));
        jTextArea4.setRows(5);
        jTextArea4.setText("               This feature is still under development.");
        jScrollPane4.setViewportView(jTextArea4);

        jPanel34.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 520, 60));

        getPayBill.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 650));

        SubTab.addTab("tab4", getPayBill);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel27.setText("Account Holder's Name");
        jPanel35.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 50));

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel28.setText("Receiver AC/No.");
        jPanel35.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 50));

        holderName.setEditable(false);
        jPanel35.add(holderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 310, 50));

        receiverAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receiverAccountFocusLost(evt);
            }
        });
        jPanel35.add(receiverAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 310, 50));

        transferSubmit.setBackground(new java.awt.Color(0, 153, 153));
        transferSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transferSubmit.setForeground(new java.awt.Color(255, 255, 255));
        transferSubmit.setText("Transfer Amount");
        transferSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferSubmitActionPerformed(evt);
            }
        });
        jPanel35.add(transferSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));
        jPanel35.add(transferAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 310, 50));

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel29.setText("Enter Amount");
        jPanel35.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 210, 50));

        javax.swing.GroupLayout getFundTransferLayout = new javax.swing.GroupLayout(getFundTransfer);
        getFundTransfer.setLayout(getFundTransferLayout);
        getFundTransferLayout.setHorizontalGroup(
            getFundTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        getFundTransferLayout.setVerticalGroup(
            getFundTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        SubTab.addTab("tab5", getFundTransfer);

        getTopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setText("Amount");
        jPanel37.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, 40));
        jPanel36.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 320, 40));

        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setText("Mobile Number");
        jPanel38.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 40));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GrameenPhone", "Banglalink", "Robi", "Airtel", "Teletalk", "Skitto" }));
        jComboBox1.setBorder(null);
        jPanel36.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 320, 40));

        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("Operator");
        jPanel39.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel36.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 40));
        jPanel36.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 320, 40));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recharge");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel36.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 180, 40));

        getTopup.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 650));

        SubTab.addTab("tab6", getTopup);

        servicePage.add(SubTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, -30, 590, 680));

        Tab.addTab("tab4", servicePage);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel41.setBackground(new java.awt.Color(0, 102, 102));
        jPanel41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.red, java.awt.Color.green));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel33.setText("History of your last 30 days transaction");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 470, 80));

        transactionTable.setBackground(new java.awt.Color(0, 102, 102));
        transactionTable.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        transactionTable.setForeground(new java.awt.Color(255, 255, 255));
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Number", "Date", "Card Number", "Received Account", "Discription", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionTable.setDoubleBuffered(true);
        transactionTable.setRowHeight(35);
        transactionTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        transactionTable.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jScrollPane5.setViewportView(transactionTable);

        jPanel40.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1230, 490));

        javax.swing.GroupLayout transactionHistoryLayout = new javax.swing.GroupLayout(transactionHistory);
        transactionHistory.setLayout(transactionHistoryLayout);
        transactionHistoryLayout.setHorizontalGroup(
            transactionHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transactionHistoryLayout.setVerticalGroup(
            transactionHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tab.addTab("tab5", transactionHistory);

        getContentPane().add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1280, 680));

        setSize(new java.awt.Dimension(1276, 729));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIconMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_menuIconMouseClicked

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        SubTab.setSelectedIndex(1);
    }//GEN-LAST:event_depositActionPerformed

    private void atmOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atmOtpActionPerformed
        SubTab.setSelectedIndex(0);
    }//GEN-LAST:event_atmOtpActionPerformed

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        SubTab.setSelectedIndex(2);

    }//GEN-LAST:event_withdrawActionPerformed

    private void billPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billPayActionPerformed
        SubTab.setSelectedIndex(3);
    }//GEN-LAST:event_billPayActionPerformed

    private void fundTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fundTransferActionPerformed
        SubTab.setSelectedIndex(4);
    }//GEN-LAST:event_fundTransferActionPerformed

    private void topUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topUpActionPerformed
        SubTab.setSelectedIndex(5);
    }//GEN-LAST:event_topUpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void otpSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpSubmitActionPerformed
        double amount = 0;
        String otp;

        if (otpAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your Amount");
            return;
        }
        amount = Double.parseDouble(otpAmount.getText());
        try {
            DBConnection c = new DBConnection();
            String name = null;
            setRs1(c.s.executeQuery("SELECT * FROM userdetails WHERE accountNumber = '" + accountNumber + "'"));
            double balance = 0;
            if (getRs1().next()) {
                balance = getRs1().getDouble("balance");
                name = getRs1().getString("name");
            }

            if (amount > 10000) {
                JOptionPane.showMessageDialog(null, "Out of Range");
                return;
            }
            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insuficient Balnace");
                return;
            } else {
                Random ran = new Random();
                long first4 = (ran.nextLong() % 9000L) + 1000L;
                otp = "" + Math.abs(first4);
            }

            c.s.executeUpdate("INSERT INTO request (accountNumber,name, otp, amount) VALUES ('" + accountNumber + "','" + name + "' ,'" + otp + "' ,'" + amount + "')");

            JOptionPane.showMessageDialog(null, "Your OTP: " + otp + "\n" + "This OTP valid for 2 minutes");
        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_otpSubmitActionPerformed

    private void withdrawSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawSubmitActionPerformed
        double amount;
        String otp;

        if (withdrawAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your Amount");
            return;
        }
        amount = Double.parseDouble(withdrawAmount.getText());
        try {
            DBConnection c = new DBConnection();
            setRs1(c.s.executeQuery("SELECT balance FROM userdetails WHERE accountNumber = '" + accountNumber + "'"));
            double balance = 0;
            if (getRs1().next()) {
                balance = getRs1().getDouble("balance");
            }

            if (amount > 10000) {
                JOptionPane.showMessageDialog(null, "Out of Range");
                return;
            }
            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insuficient Balnace");
                return;
            } else {
                Random ran = new Random();
                long first4 = (ran.nextLong() % 9000L) + 1000L;
                otp = "" + Math.abs(first4);
            }
            int response = JOptionPane.showConfirmDialog(this, "Do you want to Withdraw by OTP?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                c.s.executeUpdate("INSERT INTO withdraw (accountNumber, name, otp, amount) VALUES ('" + accountNumber + "' ,'" + AcName + "','" + otp + "' ,'" + amount + "')");

                JOptionPane.showMessageDialog(null, "Your OTP: " + otp + "\n" + "Remember the OTP for withdraw");
            } else {
                JOptionPane.showMessageDialog(null, "Withdraw Unsuccessfull");
            }

        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_withdrawSubmitActionPerformed

    private void depositSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositSubmitActionPerformed
        double amount;
        String otp;

        if (depositAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your Amount");
            return;
        }
        amount = Double.parseDouble(depositAmount.getText());
        try {
            DBConnection c = new DBConnection();

            Random ran = new Random();
            long first4 = (ran.nextLong() % 9000L) + 1000L;
            otp = "" + Math.abs(first4);

            int response = JOptionPane.showConfirmDialog(this, "Do you want to Deposit by OTP?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                c.s.executeUpdate("INSERT INTO deposit (accountNumber,name, otp, amount) VALUES ('" + accountNumber + "','" + AcName + "' ,'" + otp + "' ,'" + amount + "')");

                JOptionPane.showMessageDialog(null, "Your OTP: " + otp + "\n" + "Remember the OTP for Deposit");
            } else {
                JOptionPane.showMessageDialog(null, "Deposit Unsuccessfull");
            }
        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_depositSubmitActionPerformed

    private void receiverAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiverAccountFocusLost
        if (!receiverAccount.getText().equals("")) {
            getValue();
        }
    }//GEN-LAST:event_receiverAccountFocusLost

    private void transferSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferSubmitActionPerformed

        double amount = 0;
        long acnumber = Long.parseLong(receiverAccount.getText());
        if (transferAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your Amount");
            return;
        }
        amount = Double.parseDouble(transferAmount.getText());
        try {
            DBConnection c = new DBConnection();
            setRs1(c.s.executeQuery("SELECT balance FROM userdetails WHERE accountNumber = '" + accountNumber + "'"));
            double fromBalance = 0;
            if (getRs1().next()) {
                fromBalance = getRs1().getDouble("balance");
            }

            if (amount > 10000) {
                JOptionPane.showMessageDialog(null, "Out of Range");
                return;
            }
            if (fromBalance < amount) {
                JOptionPane.showMessageDialog(null, "Insuficient Balnace");
                return;
            }
            String discription = "Fund-Transfer";
            String dis = "Fund-Received";

            int response = JOptionPane.showConfirmDialog(this, "Do you want to Transfer?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                c.s.executeUpdate("UPDATE userdetails SET balance = balance  - '" + amount + "'  WHERE accountNumber = '" + accountNumber + "'");
                c.s.executeUpdate("UPDATE userdetails SET balance = balance +  '" + amount + "'  WHERE accountNumber = '" + acnumber + "'");
                c.s.executeUpdate("INSERT INTO transaction (accountNumber,name, fromAccount, toAccount, discription, amount) VALUES ('" + accountNumber + "','" + AcName + "', '" + accountNumber + "', '" + acnumber + "', '" + discription + "', '" + amount + "')");
                c.s.executeUpdate("INSERT INTO transaction (accountNumber, fromAccount, toAccount, discription, amount) VALUES ('" + acnumber + "', '" + accountNumber + "', '" + acnumber + "', '" + dis + "', '" + amount + "')");
                JOptionPane.showMessageDialog(null, amount + "Tk. Transfer successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Trasnfering process canceled by user");
            }

        } catch (HeadlessException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_transferSubmitActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Activity("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AcNumber;
    private javax.swing.JLabel RewardIcon;
    private javax.swing.JTabbedPane SubTab;
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JPanel accountDetails;
    private javax.swing.JTextField adress;
    private javax.swing.JTextField amount;
    private javax.swing.JButton atmOtp;
    private javax.swing.JButton billPay;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JTextField catagory;
    private javax.swing.JTextField contact;
    private javax.swing.JButton deposit;
    private javax.swing.JTextField depositAmount;
    private javax.swing.JButton depositSubmit;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField eduction;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton fundTransfer;
    private javax.swing.JTextField gender;
    private javax.swing.JPanel getDeposit;
    private javax.swing.JPanel getFundTransfer;
    private javax.swing.JPanel getOtp;
    private javax.swing.JPanel getPayBill;
    private javax.swing.JPanel getTopup;
    private javax.swing.JPanel getWithdraw;
    private javax.swing.JTextField holderName;
    private javax.swing.JPanel home;
    private javax.swing.JTextField income;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField maritalStatus;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField name;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JTextField nid;
    private javax.swing.JTextField ocupation;
    private javax.swing.JTextField otpAmount;
    private javax.swing.JButton otpSubmit;
    private javax.swing.JPanel personalDetails;
    private javax.swing.JLabel point;
    private javax.swing.JTextField postCode;
    private javax.swing.JLabel rank;
    private javax.swing.JTextField receiverAccount;
    private javax.swing.JTextField relegion;
    private javax.swing.JTextField relegion1;
    private javax.swing.JPanel servicePage;
    private javax.swing.JTextField services;
    private javax.swing.JButton topUp;
    private javax.swing.JPanel transactionHistory;
    private javax.swing.JTable transactionTable;
    private javax.swing.JTextField transferAmount;
    private javax.swing.JButton transferSubmit;
    private javax.swing.JLabel welcome;
    private javax.swing.JButton withdraw;
    private javax.swing.JTextField withdrawAmount;
    private javax.swing.JButton withdrawSubmit;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the rs1
     */
    public java.sql.ResultSet getRs1() {
        return rs1;
    }

    /**
     * @param rs1 the rs1 to set
     */
    public void setRs1(java.sql.ResultSet rs1) {
        this.rs1 = rs1;
    }
}
