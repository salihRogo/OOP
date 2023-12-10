package Week10.GradeAnalyzer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Start {
    public static void main(String[] main) throws InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> newGrades = new ArrayList<>();
        newGrades.add(8);


        Student student = new Student("Someone", 1, newGrades);
        System.out.println(student.getGrades());
        student.setGrade(9);
        student.setGrade(7);
        System.out.println(student.getGrades());


        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(student.getGrades());

        //reflection code
        Class<?> gradeAnalyzerClass = gradeAnalyzer.getClass();
        Field[] fields = gradeAnalyzerClass.getDeclaredFields();

        //printing fields and values in class
        System.out.println("Fields and values");
        for (Field field : fields){
            System.out.println(field.getName());
        }

        //iterating through declared methods and invoking those that start with "calculate" or "print"
        Method[] methods = gradeAnalyzerClass.getDeclaredMethods();
        System.out.println("Method names and results");

        for (Method method : methods){
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")){
                Object result = method.invoke(gradeAnalyzer);
                System.out.println(method.getName() + ": " + result );
            }
        }
    }
}