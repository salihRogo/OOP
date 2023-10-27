package Week3.Lecture;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();

        ds.getByGender(Gender.MALE);

        List<User> ages = ds.findAgeGreaterThan(1);

        for (User u : ages) {
            System.out.println(u.getName());
        }


    }
}
