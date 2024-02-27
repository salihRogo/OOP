package MidtermExam1stMakeupSalkan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

enum Gender {
    MALE, FEMALE
}

class Person {
    private String firstName;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        this.firstName = name;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

class Assistent extends Person {
    public Assistent(String name, int age, Gender gender) {
        super(name, age, gender);
    }
}

class Professor extends Person {
    public Professor(String name, int age, Gender gender) {
        super(name, age, gender);
    }
}

class Company<T extends Person> {
    private List<T> employees;

    public Company(List<T> employees) {
        this.employees = employees;
    }

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public Optional<List<T>> filterByGender(Gender gender) {
        List<T> returnList = new ArrayList<>();
        for (T employee : employees) {
            if(employee.getGender() == gender) {
                returnList.add(employee);
            }
        }
        return Optional.of(returnList);
    }

    public Optional<T> getByFirstName(String firstName) {
        T returnMe = null;
        for (T employee : employees) {
            if (employee.getFirstName().equals(firstName)) {
                returnMe = employee;
            }
        }
        return Optional.of(returnMe);
    }
}

class Main2 {
    public static void main(String[] args) {
        Professor p1 = new Professor("Ajdin", 22, Gender.MALE);
        Professor p2 = new Professor("Lejla", 23, Gender.FEMALE);
        Professor p3 = new Professor("Becir", 29, Gender.MALE);
        Assistent a1 = new Assistent("Salih", 21, Gender.MALE);
        Assistent a2 = new Assistent("Samira", 21, Gender.FEMALE);
        Assistent a3 = new Assistent("Emina", 20, Gender.FEMALE);

        List<Person> staff = new ArrayList<>();
        staff.add(p1);
        staff.add(p2);
        staff.add(p3);
        staff.add(a1);
        staff.add(a2);
        staff.add(a3);

        Company company = new Company(staff);

        Optional<List<Person>> filteredByGender = company.filterByGender(Gender.MALE);
        if (filteredByGender.isPresent()) {
            for (Person person : filteredByGender.get()) {
                System.out.println(person.getFirstName());
            }
        } else {
            System.out.println("There are 0 employees with given gender.");
        }

        Optional<Person> filteredByName = company.getByFirstName("Becir");
        if(filteredByName.isPresent()) {
            System.out.println(filteredByName.get().getAge());
        } else {
            System.out.println("No person with given name");
        }
    }
}
