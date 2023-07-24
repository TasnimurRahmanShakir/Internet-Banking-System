package internetbankingsystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {

    public Connection c;
    public Statement s;

    public DBConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/internet_banking_system";
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password

        try {
            // Register the JDBC driver (optional for Java SE 6 and later)
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(jdbcUrl, username, password);
            s = c.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            String errorMessage = "SQL Exception: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


}
