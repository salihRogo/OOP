package Week3.Lecture;

import java.sql.*;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "salih.13579";

    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllCustomers() throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("SELECT * FROM customers;");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            //System.out.println(rs.getString("customerNumber"));
            //System.out.println(rs.getString("customerName"));
        }
    }

    public void getCustomerById(int customerId, String customerName) throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM customers WHERE customerNumber = ? AND customerName LIKE ?");

        statement.setInt(1, customerId);
        statement.setString(2, customerName);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("customerNumber") + "\t");
            System.out.print(rs.getString("customerName") + "\n");
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();
        try {
            dbConnect.getCustomerById(103, "Atelier%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
