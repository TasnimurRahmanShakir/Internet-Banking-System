package AdminActivity;

import internetbankingsystem.DBConnection;
import internetbankingsystem.FirstPage;
import java.awt.Color;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Activity extends javax.swing.JFrame {

    private final DrawerController drawer;

    java.sql.ResultSet rs1, rs2;

    public Activity() {
        initComponents();
        welcome.setText(" Welcome, Admin ");
        drawer = Drawer.newDrawer(this)
                .header(new Header())
                .headerHeight(280)
                .separator(2, new Color(90, 90, 90))
                .space(5)
                .drawerWidth(300)
                .addChild(new DrawerItem("Home").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-home-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Pending Account").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-data-pending-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("Withdraw and Deposit").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-transaction-35.png"))).build())
                .space(7)
                .addChild(new DrawerItem("User Details").icon(new ImageIcon(getClass().getResource("/Gellary/icons8-user-details-35.png"))).build())
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

                            DefaultTableModel TBModel = (DefaultTableModel) pendingTable.getModel();
                            TBModel.setRowCount(0);
                            try {
                                String q = "SELECT * FROM registerone";
                                rs1 = c.s.executeQuery(q);
                                int i = 0;
                                while (rs1.next()) {
                                    String formNo = rs1.getString("formNo");
                                    String name = rs1.getString("name");

                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(formNo, i, 0);
                                    TBModel.setValueAt(name, i, 1);
                                    i++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            try {
                                String q1 = "SELECT * FROM registerthree";
                                rs2 = c.s.executeQuery(q1);
                                int j = 0;
                                while (rs2.next()) {
                                    String catagory = rs2.getString("catagory");

                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(catagory, j, 2);
                                    j++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            drawer.hide();
                        }
                        if (index == 2) {
                            Tab.setSelectedIndex(2);

                            DBConnection c = new DBConnection();

                            try {
                                DefaultTableModel TBModel = (DefaultTableModel) withdrawTable.getModel();

                                TBModel.setRowCount(0);
                                String q = "SELECT * FROM withdraw";
                                rs1 = c.s.executeQuery(q);
                                int i = 0;
                                while (rs1.next()) {
                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(rs1.getLong("accountNumber"), i, 0);
                                    TBModel.setValueAt(rs1.getString("name"), i, 1);
                                    TBModel.setValueAt(rs1.getString("otp"), i, 2);
                                    TBModel.setValueAt(rs1.getDouble("amount"), i, 3);
                                    i++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            try {
                                DefaultTableModel TBModel = (DefaultTableModel) depositTable.getModel();

                                TBModel.setRowCount(0);
                                String q = "SELECT * FROM deposit";
                                rs1 = c.s.executeQuery(q);
                                int i = 0;
                                while (rs1.next()) {
                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(rs1.getLong("accountNumber"), i, 0);
                                    TBModel.setValueAt(rs1.getString("name"), i, 1);
                                    TBModel.setValueAt(rs1.getString("otp"), i, 2);
                                    TBModel.setValueAt(rs1.getDouble("amount"), i, 3);
                                    i++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            drawer.hide();

                        }

                        if (index == 3) {
                            Tab.setSelectedIndex(3);

                            DBConnection c = new DBConnection();

                            DefaultTableModel TBModel = (DefaultTableModel) userTable.getModel();

                            TBModel.setRowCount(0);
                            try {
                                String q = "SELECT * FROM userdetails";
                                rs1 = c.s.executeQuery(q);
                                int i = 0;
                                while (rs1.next()) {
                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(rs1.getLong("accountNumber"), i, 0);
                                    TBModel.setValueAt(rs1.getString("name"), i, 1);
                                    TBModel.setValueAt(rs1.getString("dob"), i, 2);
                                    TBModel.setValueAt(rs1.getDouble("cardNumber"), i, 3);

                                    TBModel.setValueAt(rs1.getString("nid"), i, 4);
                                    TBModel.setValueAt(rs1.getString("contact"), i, 5);
                                    TBModel.setValueAt(rs1.getDouble("balance"), i, 6);
                                    i++;
                                }
                            } catch (SQLException e) {
                                String errorMessage = "SQL Exception: " + e.getMessage();
                                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            drawer.hide();

                        }
                        if (index == 4) {
                            Tab.setSelectedIndex(4);
                            DBConnection c = new DBConnection();

                            DefaultTableModel TBModel = (DefaultTableModel) transactionTable.getModel();

                            TBModel.setRowCount(0);
                            try {
                                String q = "SELECT * FROM transaction";
                                rs1 = c.s.executeQuery(q);
                                int i = 0;
                                while (rs1.next()) {
                                    // Add a new row to the model
                                    TBModel.addRow(new Object[]{});

                                    // Set the value at the specified column and row
                                    TBModel.setValueAt(rs1.getLong("accountNumber"), i, 0);
                                    TBModel.setValueAt(rs1.getString("name"), i, 1);
                                    TBModel.setValueAt(rs1.getString("date"), i, 2);
                                    TBModel.setValueAt(rs1.getString("cardNumber"), i, 3);
                                    TBModel.setValueAt(rs1.getLong("toAccount"), i, 4);
                                    TBModel.setValueAt(rs1.getString("discription"), i, 5);
                                    TBModel.setValueAt(rs1.getDouble("amount"), i, 6);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationPanel = new javax.swing.JPanel();
        menuIcon = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        Tab = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        pendingAccount = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingTable = new javax.swing.JTable();
        approve = new javax.swing.JButton();
        decline = new javax.swing.JButton();
        details = new javax.swing.JButton();
        withdraAndDeposit = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        withdrawTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        withdrawSearch = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        depositSearch = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        depositTable = new javax.swing.JTable();
        withdrawDecline = new javax.swing.JButton();
        withdrawApprove = new javax.swing.JButton();
        depositApprove = new javax.swing.JButton();
        depositDecline = new javax.swing.JButton();
        customerDetails = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        userDetailsButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        userSearch = new javax.swing.JTextField();
        transactionHistory = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        transactionHistory1 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

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
        navigationPanel.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 50));

        welcome.setBackground(new java.awt.Color(255, 255, 255));
        welcome.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-male-user-35.png"))); // NOI18N
        welcome.setAutoscrolls(true);
        navigationPanel.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 17, 370, 50));

        getContentPane().add(navigationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 80));

        Tab.addTab("tab4", home);

        pendingAccount.setBackground(new java.awt.Color(255, 255, 255));
        pendingAccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.blue, java.awt.Color.blue));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel1.setText("List of Pending account");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 340, 70));

        pendingAccount.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 380, 70));

        pendingTable.setBackground(new java.awt.Color(0, 102, 102));
        pendingTable.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        pendingTable.setForeground(new java.awt.Color(255, 255, 255));
        pendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Form No.", "Name.", "Account Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingTable.setGridColor(new java.awt.Color(255, 255, 255));
        pendingTable.setRowHeight(30);
        pendingTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        pendingTable.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(pendingTable);

        pendingAccount.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1230, 450));

        approve.setBackground(new java.awt.Color(0, 102, 102));
        approve.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        approve.setForeground(new java.awt.Color(255, 255, 255));
        approve.setText("Approve");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        pendingAccount.add(approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 580, 100, 30));

        decline.setBackground(new java.awt.Color(0, 102, 102));
        decline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        decline.setForeground(new java.awt.Color(255, 255, 255));
        decline.setText("Decline");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        pendingAccount.add(decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 100, 30));

        details.setBackground(new java.awt.Color(0, 102, 102));
        details.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        details.setForeground(new java.awt.Color(255, 255, 255));
        details.setText("Details");
        details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsActionPerformed(evt);
            }
        });
        pendingAccount.add(details, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 580, 100, 30));

        Tab.addTab("tab3", pendingAccount);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        withdrawTable.setBackground(new java.awt.Color(0, 102, 102));
        withdrawTable.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        withdrawTable.setForeground(new java.awt.Color(255, 255, 255));
        withdrawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Number", "Name", "OTP", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        withdrawTable.setDoubleBuffered(true);
        withdrawTable.setRowHeight(35);
        withdrawTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        withdrawTable.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jScrollPane7.setViewportView(withdrawTable);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1230, 220));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-search (1).gif"))); // NOI18N
        jLabel4.setText("Search");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 100, 30));

        withdrawSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        withdrawSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        withdrawSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        withdrawSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                withdrawSearchKeyReleased(evt);
            }
        });
        jPanel5.add(withdrawSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 370, 30));

        jPanel42.setBackground(new java.awt.Color(0, 102, 102));
        jPanel42.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.red, java.awt.Color.green));

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel34.setText("Withdraw Request");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 470, 50));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-search (1).gif"))); // NOI18N
        jLabel5.setText("Search");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 100, 30));

        depositSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        depositSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        depositSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        depositSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                depositSearchKeyReleased(evt);
            }
        });
        jPanel5.add(depositSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 370, 30));

        jPanel43.setBackground(new java.awt.Color(0, 102, 102));
        jPanel43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.red, java.awt.Color.green));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel35.setText("Deposit Request");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 470, 50));

        depositTable.setBackground(new java.awt.Color(0, 102, 102));
        depositTable.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        depositTable.setForeground(new java.awt.Color(255, 255, 255));
        depositTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Number", "Name", "OTP", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        depositTable.setDoubleBuffered(true);
        depositTable.setRowHeight(35);
        depositTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        depositTable.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jScrollPane8.setViewportView(depositTable);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 1230, 220));

        withdrawDecline.setBackground(new java.awt.Color(0, 102, 102));
        withdrawDecline.setForeground(new java.awt.Color(255, 255, 255));
        withdrawDecline.setText("Decline");
        withdrawDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawDeclineActionPerformed(evt);
            }
        });
        jPanel5.add(withdrawDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 300, 90, 30));

        withdrawApprove.setBackground(new java.awt.Color(0, 102, 102));
        withdrawApprove.setForeground(new java.awt.Color(255, 255, 255));
        withdrawApprove.setText("Approve");
        withdrawApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawApproveActionPerformed(evt);
            }
        });
        jPanel5.add(withdrawApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 90, 30));

        depositApprove.setBackground(new java.awt.Color(0, 102, 102));
        depositApprove.setForeground(new java.awt.Color(255, 255, 255));
        depositApprove.setText("Approve");
        depositApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositApproveActionPerformed(evt);
            }
        });
        jPanel5.add(depositApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 620, 90, 30));

        depositDecline.setBackground(new java.awt.Color(0, 102, 102));
        depositDecline.setForeground(new java.awt.Color(255, 255, 255));
        depositDecline.setText("Decline");
        depositDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositDeclineActionPerformed(evt);
            }
        });
        jPanel5.add(depositDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 90, 30));

        javax.swing.GroupLayout withdraAndDepositLayout = new javax.swing.GroupLayout(withdraAndDeposit);
        withdraAndDeposit.setLayout(withdraAndDepositLayout);
        withdraAndDepositLayout.setHorizontalGroup(
            withdraAndDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        withdraAndDepositLayout.setVerticalGroup(
            withdraAndDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tab.addTab("tab5", withdraAndDeposit);

        customerDetails.setBackground(new java.awt.Color(255, 255, 255));
        customerDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.blue, java.awt.Color.blue));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel2.setText("List of User account");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 340, 70));

        customerDetails.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 380, 70));

        userTable.setBackground(new java.awt.Color(0, 102, 102));
        userTable.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        userTable.setForeground(new java.awt.Color(255, 255, 255));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Number", "Name", "Date of Birth", "Card Number", "NID", "Contact Number", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setDoubleBuffered(true);
        userTable.setRowHeight(35);
        userTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(userTable);

        customerDetails.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1230, 450));

        userDetailsButton.setBackground(new java.awt.Color(0, 102, 102));
        userDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
        userDetailsButton.setText("Details");
        userDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDetailsButtonActionPerformed(evt);
            }
        });
        customerDetails.add(userDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 590, 80, 30));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-search (1).gif"))); // NOI18N
        jLabel6.setText("Search");
        customerDetails.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 100, 30));

        userSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        userSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        userSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userSearchKeyReleased(evt);
            }
        });
        customerDetails.add(userSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 370, 30));

        Tab.addTab("tab1", customerDetails);

        transactionHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel41.setBackground(new java.awt.Color(0, 102, 102));
        jPanel41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, java.awt.Color.red, java.awt.Color.green));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-list.gif"))); // NOI18N
        jLabel33.setText("User's last 30 days transaction history");

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
                "Account Number", "Name", "Date", "Card Number", "Received Account", "Discription", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane5.setViewportView(transactionTable);

        jPanel40.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1230, 490));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/icons8-search (1).gif"))); // NOI18N
        jLabel3.setText("Search");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        jPanel40.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 120, 30));

        search.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel40.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 370, 30));

        javax.swing.GroupLayout transactionHistory1Layout = new javax.swing.GroupLayout(transactionHistory1);
        transactionHistory1.setLayout(transactionHistory1Layout);
        transactionHistory1Layout.setHorizontalGroup(
            transactionHistory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transactionHistory1Layout.setVerticalGroup(
            transactionHistory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionHistory1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(transactionHistory1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        transactionHistory.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 650));

        Tab.addTab("tab2", transactionHistory);

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

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsActionPerformed
        int selectedRowIndex = pendingTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            String formNo = pendingTable.getValueAt(selectedRowIndex, 0).toString();
            new PendingAccountDetails(formNo).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }


    }//GEN-LAST:event_detailsActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        int selectedRowIndex = pendingTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            int response = JOptionPane.showConfirmDialog(this, "Do you want to Approve?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                String formNo = pendingTable.getValueAt(selectedRowIndex, 0).toString();
                DBConnection c = new DBConnection();
                try {
                    String q1 = "DELETE FROM registerone WHERE formNo = '" + formNo + "'";
                    String q2 = "DELETE FROM registertwo WHERE formNo = '" + formNo + "'";
                    String q3 = "DELETE FROM registerthree WHERE formNo = '" + formNo + "'";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    DefaultTableModel model = (DefaultTableModel) pendingTable.getModel();
                    model.removeRow(selectedRowIndex);
                    pendingTable.repaint();
                } catch (SQLException e) {
                    String errorMessage = "SQL Exception: " + e.getMessage();
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_declineActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        int selectedRowIndex = pendingTable.getSelectedRow();

        if (selectedRowIndex != -1) {
            int response = JOptionPane.showConfirmDialog(this, "Do you want to Approve?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String formNo = pendingTable.getValueAt(selectedRowIndex, 0).toString();
                DBConnection c = new DBConnection();
                double balance = 0.0;
                try {
                    String q = "INSERT INTO userdetails (userName, pass, cardNumber, pinNumber, name, fname, mname, dob, contact, email, nid, gender, maritalStatus, relegion, ocupation , education, income, adress, postCode, catagory, services,balance, photo) SELECT three.userName, three.password, three.cardNumber, three.pinNumber, one.name, one.fname, one.mname, one.dob, one.contact, one.email, one.nid, one.gender, one.maritalStatus, two.relegion, two.ocupation, two.education, two.income, two.adress, two.postCode, three.catagory, three.services,'"+balance+"', one.photo FROM registerone AS one JOIN registertwo AS two ON one.formNo = two.formNo JOIN registerthree AS three ON one.formNo = three.formNo WHERE one.formNo = '" + formNo + "'";
                    c.s.executeUpdate(q);

                    JOptionPane.showMessageDialog(null, "Account Approved successfully");
                    String q1 = "DELETE FROM registerone WHERE formNo = '" + formNo + "'";
                    String q2 = "DELETE FROM registertwo WHERE formNo = '" + formNo + "'";
                    String q3 = "DELETE FROM registerthree WHERE formNo = '" + formNo + "'";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    DefaultTableModel model = (DefaultTableModel) pendingTable.getModel();
                    model.removeRow(selectedRowIndex);
                    pendingTable.repaint();
                } catch (SQLException e) {
                    String errorMessage = "SQL Exception: " + e.getMessage();
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_approveActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String str = search.getText();
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        transactionTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }//GEN-LAST:event_searchKeyReleased

    private void userDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDetailsButtonActionPerformed

        int selectedRowIndex = userTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            try {
                String accountNumber = userTable.getValueAt(selectedRowIndex, 0).toString();
                new AccountDetails(accountNumber).setVisible(true);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_userDetailsButtonActionPerformed

    private void withdrawSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withdrawSearchKeyReleased
        String str = withdrawSearch.getText();
        DefaultTableModel model = (DefaultTableModel) withdrawTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        withdrawTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }//GEN-LAST:event_withdrawSearchKeyReleased

    private void depositSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depositSearchKeyReleased
        String str = depositSearch.getText();
        DefaultTableModel model = (DefaultTableModel) depositTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        depositTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }//GEN-LAST:event_depositSearchKeyReleased

    private void userSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userSearchKeyReleased
        String str = userSearch.getText();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        userTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }//GEN-LAST:event_userSearchKeyReleased

    private void withdrawApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawApproveActionPerformed

        int selectedRowIndex = withdrawTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            long accountNumber = (long) withdrawTable.getValueAt(selectedRowIndex, 0);
            String otp = (String) withdrawTable.getValueAt(selectedRowIndex, 2);
            double amount = 0;
            String name = null;
            try {
                DBConnection c = new DBConnection();
                rs1 = c.s.executeQuery("SELECT * FROM withdraw WHERE accountNumber = '" + accountNumber + "'");

                if (rs1.next()) {
                    amount = rs1.getDouble("amount");

                    name = rs1.getString("name");
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot find any data");
                }
                String discription = "Withdraw by Agent";
                int response = JOptionPane.showConfirmDialog(this, "Do you want to Confirm?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    c.s.executeUpdate("UPDATE userdetails SET balance = balance  - '" + amount + "', point = point + 10  WHERE accountNumber = '" + accountNumber + "'");
                    c.s.executeUpdate("INSERT INTO transaction (accountNumber, name, discription, amount) VALUES ('" + accountNumber + "', '" + name + "', '" + discription + "', '" + amount + "')");
                    c.s.executeUpdate("DELETE FROM withdraw WHERE otp = '" + otp + "'");
                    JOptionPane.showMessageDialog(null, amount + "Tk. Withdraw successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Withdraw process canceled by user");
                }

            } catch (SQLException e) {
                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_withdrawApproveActionPerformed

    private void depositApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositApproveActionPerformed
        int selectedRowIndex = depositTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            long accountNumber = (long) depositTable.getValueAt(selectedRowIndex, 0);
            String otp = (String) depositTable.getValueAt(selectedRowIndex, 2);
            double amount = 0;
            String name = null;
            try {
                DBConnection c = new DBConnection();
                rs1 = c.s.executeQuery("SELECT * FROM deposit WHERE accountNumber = '" + accountNumber + "'");

                if (rs1.next()) {
                    amount = rs1.getDouble("amount");

                    name = rs1.getString("name");
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot find any data");
                }
                String discription = "Deposit by Agent";
                int response = JOptionPane.showConfirmDialog(this, "Do you want to Confirm?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    c.s.executeUpdate("UPDATE userdetails SET balance = balance  + '" + amount + "', point = point + 10  WHERE accountNumber = '" + accountNumber + "'");
                    c.s.executeUpdate("INSERT INTO transaction (accountNumber, name, discription, amount) VALUES ('" + accountNumber + "', '" + name + "', '" + discription + "', '" + amount + "')");
                    c.s.executeUpdate("DELETE FROM deposit WHERE otp = '" + otp + "'");
                    JOptionPane.showMessageDialog(null, amount + "Tk. Deposit successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit process canceled by user");
                }

            } catch (SQLException e) {
                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_depositApproveActionPerformed

    private void withdrawDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawDeclineActionPerformed
        int selectedRowIndex = withdrawTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            long accountNumber = (long) withdrawTable.getValueAt(selectedRowIndex, 0);
            String otp = (String) withdrawTable.getValueAt(selectedRowIndex, 2);

            try {
                DBConnection c = new DBConnection();

                int response = JOptionPane.showConfirmDialog(this, "Do you want to Decline?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {

                    c.s.executeUpdate("DELETE FROM withdraw WHERE otp = '" + otp + "'");
                    JOptionPane.showMessageDialog(null, " successfully Decline");
                } else {
                    JOptionPane.showMessageDialog(null, "Withdraw process canceled by user");
                }

            } catch (SQLException e) {
                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_withdrawDeclineActionPerformed

    private void depositDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositDeclineActionPerformed
        int selectedRowIndex = depositTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            String otp = (String) depositTable.getValueAt(selectedRowIndex, 2);

            try {
                DBConnection c = new DBConnection();

                int response = JOptionPane.showConfirmDialog(this, "Do you want to Decline?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {

                    c.s.executeUpdate("DELETE FROM deposit WHERE otp = '" + otp + "'");
                    JOptionPane.showMessageDialog(null, " successfully Decline");
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit process canceled by user");
                }

            } catch (SQLException e) {
                String errorMessage = "SQL Exception: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection");
        }
    }//GEN-LAST:event_depositDeclineActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Activity().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton approve;
    private javax.swing.JPanel customerDetails;
    private javax.swing.JButton decline;
    private javax.swing.JButton depositApprove;
    private javax.swing.JButton depositDecline;
    private javax.swing.JTextField depositSearch;
    private javax.swing.JTable depositTable;
    private javax.swing.JButton details;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JPanel pendingAccount;
    private javax.swing.JTable pendingTable;
    private javax.swing.JTextField search;
    private javax.swing.JPanel transactionHistory;
    private javax.swing.JPanel transactionHistory1;
    private javax.swing.JTable transactionTable;
    private javax.swing.JButton userDetailsButton;
    private javax.swing.JTextField userSearch;
    private javax.swing.JTable userTable;
    private javax.swing.JLabel welcome;
    private javax.swing.JPanel withdraAndDeposit;
    private javax.swing.JButton withdrawApprove;
    private javax.swing.JButton withdrawDecline;
    private javax.swing.JTextField withdrawSearch;
    private javax.swing.JTable withdrawTable;
    // End of variables declaration//GEN-END:variables
}
