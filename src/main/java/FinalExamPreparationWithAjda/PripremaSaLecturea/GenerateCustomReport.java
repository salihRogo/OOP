package FinalExamPreparationWithAjda.PripremaSaLecturea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class GenerateCustomReport {
    public static void writeReport(String outputFileName, List<Item> items) {
        Class<?> clazz = Item.class;
        Field[] fields = clazz.getDeclaredFields();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            for (Item item : items) {
                String temp = "";
                for (Field field : fields) {
                    if (field.isAnnotationPresent(WritableField.class)) {
                        field.setAccessible(true);
                        temp = temp.concat(field.get(item).toString().concat(","));
                    }
                }
                writer.write(temp.substring(0, temp.length() - 1).concat("\n"));
            }
            writer.close();
        } catch (IOException e) {
            throw new InvalidCastException("IO problems!");
        } catch (IllegalAccessException e) {
            throw new InvalidCastException("You tried to access something that you shouldn't!");
        }
    }
}
