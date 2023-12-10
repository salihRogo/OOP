package Week10.GradeAnalyzer;

import java.util.ArrayList;

public class Student {
    private String name;
    private int ID;
    private ArrayList<Integer> grades;

    public Student (String name, int id, ArrayList<Integer> grades){
        this.name = name;
        this.ID = id;
        this.grades = grades;
    }

    public void printInfo(){
        System.out.println(this.name + ", " + this.ID + " \n grades:");
        for (int i : grades){
            System.out.println(i + ", ");
        }
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Integer> getGrades() {
        return this.grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGrade(int grade) {
        this.grades.add(grade);
    }
}
