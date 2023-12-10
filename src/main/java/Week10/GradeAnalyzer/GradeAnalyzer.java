package Week10.GradeAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class GradeAnalyzer {
    public ArrayList <Integer> grades;

    public GradeAnalyzer( ArrayList<Integer> grades){
        this.grades=grades;
    }

    public double printSum (){
        double sum = 0;
        for (int i : this.grades){
            sum += i;
        }
        return sum;
    }
    public double calculateAverage (){
        double sum = printSum();
        return (sum/this.grades.size());
    }

}
