package Homework4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task7_File_overwrite {

    private static final String INPUT_FILE = "INPUT.txt";
    private static final String OUTPUT_FILE = "OUTPUT.txt";

    public static void main(String[] args) {

        Deque<String> stringsFromFile = new ArrayDeque<>();


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            String inputString;
            while ((inputString = reader.readLine()) != null) {
                stringsFromFile.push(inputString);
            }
            while (!stringsFromFile.isEmpty()) {
                writer.write(stringsFromFile.pollFirst());
                writer.newLine();
            }
            writer.flush();
            System.out.println("Operation is finished");
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
