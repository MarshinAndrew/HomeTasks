package Classwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) {
        while (true) {
            System.out.println(method());

        }
    }

    public static String method() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();

        } catch (
                IOException e) {

        }
        return null;
    }
}
