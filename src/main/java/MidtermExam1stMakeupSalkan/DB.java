package MidtermExam1stMakeupSalkan;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DB {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/Animals";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "salih.13579";
    private Connection connection = null;

    public DB() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAnimals(String name, int id) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("SELECT * FROM AnimalTable WHERE name = ? AND id >= ?;");
        statement.setString(1, name);
        statement.setInt(2, id);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id") + "->" + rs.getString("name") + "->" + rs.getString("type"));
        }
        rs.close();
    }
}

class Main4 {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            db.getAnimals("Animal74", 54);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
