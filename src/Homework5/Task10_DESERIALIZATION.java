package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task10_DESERIALIZATION {

    private static final String INPUT_FILE = "FILE_NAME";
    private static final String OUTPUT_FILE = "OUTPUT.txt";

    public static void main(String[] args) {

        List<Box> list = deserilizeObjectFromFile(INPUT_FILE);
        if (!list.isEmpty()) {
            Collections.sort(list);
            System.out.println(list);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                writer.write("Max volume is " + list.get(list.size() - 1).getVolume());
                writer.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private static <T> List<T> deserilizeObjectFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return list;
    }
}
