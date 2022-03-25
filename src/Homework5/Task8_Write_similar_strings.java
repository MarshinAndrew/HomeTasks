package Homework5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Task8_Write_similar_strings {

    private static final String INPUT_FILE1 = "INPUT_1.txt";
    private static final String INPUT_FILE2 = "INPUT_2.txt";
    private static final String OUTPUT_FILE = "OUTPUT2.txt";


    public static void main(String[] args) {

        Set<String> list = new HashSet<>();

        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE1)));
             BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE2)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            String inputString;
            while ((inputString = reader1.readLine()) != null) {
                list.add(inputString);
            }
            while ((inputString = reader2.readLine()) != null) {
                if (list.contains(inputString)) {
                    list.remove(inputString);
                    writer.write(inputString);
                    writer.newLine();
                }
            }
            writer.flush();
            System.out.println("Operation is finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

