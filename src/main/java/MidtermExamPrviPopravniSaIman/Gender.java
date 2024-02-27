package MidtermExamPrviPopravniSaIman;

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

    public Person(String firstName, int age, Gender gender) {
        this.firstName = firstName;
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

class Assistant extends Person {
    public Assistant(String firstName, int age, Gender gender) {
        super(firstName, age, gender);
    }
}

class Professor extends Person {
    public Professor(String firstName, int age, Gender gender) {
        super(firstName, age, gender);
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
        List<T> returnMe = new ArrayList<>();

        for (T employee : employees) {
            if (employee.getGender() == gender) {
                returnMe.add(employee);
            }
        }

        return Optional.of(returnMe);
    }

    public Optional<T> getByFirstName(String firstName) {
        for (T employee : employees) {
            if (employee.getFirstName().equals(firstName)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }
}

class Main2 {
    public static void main(String[] args) {
        Professor p1 = new Professor("Ajdin", 22, Gender.MALE);
        Professor p2 = new Professor("Lejla", 23, Gender.FEMALE);
        Professor p3 = new Professor("Becir", 29, Gender.MALE);
        Assistant a1 = new Assistant("Salih", 21, Gender.MALE);
        Assistant a2 = new Assistant("Samira", 21, Gender.FEMALE);
        Assistant a3 = new Assistant("Emina", 20, Gender.FEMALE);

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
