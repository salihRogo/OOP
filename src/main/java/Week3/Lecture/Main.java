package Week3.Lecture;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();

        ds.getByGender(Gender.MALE);

        List<User> users = ds.getAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
