package FinalExamPreparationWithAjda.StudentSystem;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class Student {
    @ImportantInformation
    private int studentID;
    @ImportantInformation
    private String name;
    private String university;
    private String department;
    @ImportantInformation
    private double GPA;

    public Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.name = builder.name;
        this.university = builder.university;
        this.department = builder.department;
        this.GPA = builder.GPA;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public double getGPA() {
        return GPA;
    }

    static class StudentBuilder {
        private int studentID;
        private String name;
        private String university;
        private String department;
        private double GPA;

        public StudentBuilder setStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public StudentBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public StudentBuilder setGPA(double GPA) {
            this.GPA = GPA;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantInformation {}

class StudentSystem {
    private static ArrayList<Student> students;

    public StudentSystem(String filename) {
        try {
            students = readStudentsCSVFile(filename);
        } catch (IOException e) {
            System.out.println("IO problems.");
        }
    }

    public static ArrayList<Student> readStudentsCSVFile(String filename) throws IOException {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        List<String> lines = reader.lines().toList();
        for (String line : lines) {
            String[] splited = line.split(",");
            Student temp = new Student.StudentBuilder()
                    .setStudentID(Integer.parseInt(splited[0]))
                    .setName(splited[1])
                    .setUniversity(splited[2])
                    .setDepartment(splited[3])
                    .setGPA(Double.parseDouble(splited[4]))
                    .build();

            studentArrayList.add(temp);
        }

        reader.close();
        return studentArrayList;
    }

    public static void generateReportAboutStudents(String filename) throws IOException, IllegalAccessException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        Class<?> classObject = Student.class;
        Field[] fields = classObject.getDeclaredFields();

        for (Student student : students) {
            String temp = "";
            for (Field field : fields) {
                if (field.isAnnotationPresent(ImportantInformation.class)) {
                    field.setAccessible(true);
                    String fieldValue = field.get(student).toString();
                    temp = temp + fieldValue + ",";
                }
            }
            writer.write(temp.substring(0, temp.length()-1) + "\n");
        }
        writer.close();
    }
}




















