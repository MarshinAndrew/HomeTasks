package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_Average_From_Console {

    static final String STOP_WORD = "stop";
    static final String NUMBER_CONTROL_MESSAGE = "Only numbers available";

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        String stringFromConsole;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while ((stringFromConsole = reader.readLine()) != null) {
                if (!stringFromConsole.trim().equalsIgnoreCase(STOP_WORD)) {
                    try {
                        list.add(Double.parseDouble(stringFromConsole));
                    } catch (NumberFormatException e) {
                        System.out.println(NUMBER_CONTROL_MESSAGE);
                    }
                } else {
                    break;
                }
            }
            System.out.println("Average value is " + getAverage(list));
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }

    private static Double getAverage(List<Double> list) {
        if (list == null) {
            throw new NullPointerException("Input parameter is null!!!");
        }
        Double average = 0.0;

        if (list.size() != 0) {
            for (Double number : list) {
                average += number;
            }
            return average / list.size();
        }
        return average;
    }
}
