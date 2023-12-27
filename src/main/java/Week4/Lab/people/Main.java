package Week4.Lab.people;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printDepartment(List<Person> people){
        for (Person p : people){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );

        printDepartment(people);

        Student salih = new Student("Salih Rogo", "Hamdije Cresevljakovica 10");
        salih.addGrade(5);
        salih.addGrade(4);
        salih.displayGrades();
        Student emina = new Student("Emina Rogo", "Abdurahmana Syria 19");
        emina.addGrade(10);
        emina.addGrade(1);
        emina.addGrade(4);
        emina.displayGrades();
    }
}
