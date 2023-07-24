package SplashActivity;

import internetbankingsystem.FirstPage;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

public class LoginSplash extends javax.swing.JFrame {

    private static boolean internet = false;

    public LoginSplash() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadingnumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loadingtext = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadingnumber.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loadingnumber.setForeground(new java.awt.Color(255, 255, 255));
        loadingnumber.setText("0%");
        jPanel1.add(loadingnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gellary/pleasewait.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 820, 210));

        loadingtext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loadingtext.setForeground(new java.awt.Color(255, 255, 255));
        loadingtext.setText("Loading.....");
        jPanel1.add(loadingtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 370, -1));

        progressBar.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 820, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 490));

        setSize(new java.awt.Dimension(816, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            internet = true;
            System.out.println("Internet is connected");
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
            internet = false;
        } catch (IOException e) {
            internet = false;
            System.out.println("Internet is not connected");
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        LoginSplash startActiviy = new LoginSplash();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                startActiviy.setVisible(true);
            }
        });

        try {

            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                startActiviy.progressBar.setValue(i);
                LoginSplash.loadingnumber.setText(Integer.toString(i) + "%");

                switch (i) {
                    case 0:
                        startActiviy.loadingtext.setText("Turning on Modules.....");
                        break;
                    case 20:
                        startActiviy.loadingtext.setText("Loding Modules.....");
                        break;
                    case 30:
                        startActiviy.loadingtext.setText("Checking Internet Connection.....");
                        break;
                    case 40:
                        startActiviy.loadingtext.setText("Internet Connected....");
                        break;
                    case 50:
                        startActiviy.loadingtext.setText("Connectiong to Database.....");
                        break;
                    case 60:
                        startActiviy.loadingtext.setText("Connection Successfull !");
                        break;
                    case 70:
                        startActiviy.loadingtext.setText("Initialize Application.....");
                        break;
                    case 80:
                        startActiviy.loadingtext.setText("Loding plugins.....");
                        break;
                    case 90:
                        startActiviy.loadingtext.setText("Launching Application.....");
                        break;
                    default:
                        break;
                }

                if (i == 100) {
                    if (internet == true) {
                        //  JOptionPane.showMessageDialog(null, "internet connection");

                        new FirstPage().setVisible(true);
                        startActiviy.setVisible(false);
                        startActiviy.dispose();

                    } else {

                        JOptionPane.showMessageDialog(null, "No internet connection");
                        startActiviy.setVisible(false);
                        startActiviy.dispose();
                    }

                }
            }
        } catch (HeadlessException | InterruptedException e) {
            System.out.println(e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel loadingnumber;
    private javax.swing.JLabel loadingtext;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
