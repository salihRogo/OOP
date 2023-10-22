package Week3.Lecture;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DbConnect db = new DbConnect();

        try {
            db.getAllCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
