package Homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task4_Sort_Numbers_From_Console {
    static final String STOP_WORD = "stop";
    static final String STATUS_WORD = "status";
    static final String NUMBERS_CONTROL_MESSAGE = "Only numbers available";

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        String stringFromConsole;
        Boolean stopEnter = false;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while ((stringFromConsole = reader.readLine()) != null) {
                if (stringFromConsole.trim().equalsIgnoreCase(STOP_WORD)) {
                    stopEnter = true;
                }
                if (!stopEnter) {
                    try {
                        list.add(Double.parseDouble(stringFromConsole));
                    } catch (NumberFormatException e) {
                        System.out.println(NUMBERS_CONTROL_MESSAGE);
                    }
                } else if (stringFromConsole.trim().equalsIgnoreCase(STATUS_WORD)) {
                    Collections.sort(list);
                    System.out.println(list);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }


    }
}
