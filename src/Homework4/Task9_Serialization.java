package Homework4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task9_Serialization {

    private static final Random RANDOM = new Random();
    private static final String FILE_NAME = "FILE_NAME";

    public static void main(String[] args) {

        List<Box> listBox = new ArrayList<>();
        while (listBox.size() < 5) {
            listBox.add(createBox());
        }
        serializeListOfObject(listBox, FILE_NAME);
        System.out.println("Operation is finished");

    }

    private static Box createBox() {
        return new Box(RANDOM.nextInt(20), RANDOM.nextInt(20), RANDOM.nextInt(20));
    }

    private static void serializeListOfObject(List<?> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
