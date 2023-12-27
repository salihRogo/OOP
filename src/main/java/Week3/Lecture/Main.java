package Week3.Lecture;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();

        List<User> resultSet = ds.multiplyAgeReturnUserAndPrint();

        for (User u : resultSet) {
            System.out.println(u);
        }

        List<User> task2 = ds.multiplyAgeReturnUserAndPrint();

        for (User u : task2) {
            System.out.println(u);
        }

        //List<User> task3 = ds.getAll();
        /*
        for(User u : task3){
            System.out.println(u);
        } */
    }
}
