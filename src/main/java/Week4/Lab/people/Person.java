package Week4.Lab.people;

import java.util.ArrayList;

class Person {
    private String nameAndSurname;
    private String address;
    private int age;
    private String country;

    public Person(String nameAndSurname, String address) {
        this.nameAndSurname = nameAndSurname;
        this.address = address;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return this.nameAndSurname + "\n \t" + this.address;
    }
}

class Student extends Person {
    private int ncredits = 0;
    private String student_id;
    private ArrayList<Integer> grades = new ArrayList<Integer>();

    public Student(String nameAndSurname, String address) {
        super(nameAndSurname, address);
    }

    public int credits() {
        return ncredits;
    }

    public void study() {
        ncredits++;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void addGrade(Integer grade){
        if (grade > 0 && grade < 11)
            this.grades.add(grade);
    }

    public void displayGrades(){
        for (int i : this.grades){
            System.out.println(i);
        }
    }
}

class Teacher extends Person {
    private int salary;
    public Teacher(String nameAndSurname, String address, int salary) {
        super(nameAndSurname, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n \t" + "salary " + this.salary + " euros/month";
    }
}
