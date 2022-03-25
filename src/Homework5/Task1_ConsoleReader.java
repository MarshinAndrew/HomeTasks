package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task1_ConsoleReader {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println(reader.readLine());

            }
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
