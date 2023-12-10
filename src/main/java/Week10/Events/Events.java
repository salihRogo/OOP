package Week10.Events;

import java.io.*;
import java.util.List;
import java.util.Random;

public class Events {

    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private static final int NUM_OF_RECORDS = 1000000;

    public static void generateEventsFile(String filename) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filename)
        );

        Random random = new Random();
        for (int i = 0; i < NUM_OF_RECORDS; i++) {
            int timestamp = random.nextInt(Integer.MAX_VALUE);
            String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];
            int userID = random.nextInt(1000);

            bufferedWriter.write(timestamp + ", " + eventType + ", " + userID);
            bufferedWriter.newLine(); //do not forget this one
        }

        bufferedWriter.close();
    }

    public static void readEventsFile(String filename) throws IOException {
        //it should read the file in 5 iterations
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filename)
        );
        int iteration = 1;
        //with streams
        List<String> lines = bufferedReader.lines().toList();
        for (int i = 0; i < 5; i++) {
            for (String line : lines)
                System.out.println(line);
            iteration = (iteration % 5) + 1;
        }

        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        //specify the file name (e.g. "events.txt")
        String filename = "events.txt";

        generateEventsFile("events.txt");
        readEventsFile("events.txt");

    }
}