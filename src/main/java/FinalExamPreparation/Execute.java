package FinalExamPreparation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Execute {
    public static void main(String[] args) {

        try {
            GenerateReport.vblalla();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
