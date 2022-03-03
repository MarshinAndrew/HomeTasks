package Homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Task6_Calculator {


   private static final String NUMBER_CONTROL_MESSAGE = "Only numbers available";
   private static final String FINISH_APPLICATION = "x";
   private static final String ZERO_DIVISION = "Division on zero is illegal";


    public static void main(String[] args) {
        Double operand1;
        Double operand2;
        String operationType;

        System.out.println("To finish press  " + "'" + FINISH_APPLICATION + "'\n");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    System.out.println("Enter operand1");
                    operand1 = getNumber(reader);
                    System.out.println("Select operation type");
                    operationType = getOperationType(reader);
                    System.out.println("Enter operand2");
                    operand2 = getNumber(reader);
                    System.out.println();
                    switch (operationType) {
                        case "+":
                            System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2) + "\n");
                            break;
                        case "-":
                            System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2) + "\n");
                            break;
                        case "*":
                            System.out.println(operand1 + " * " + operand2 + " = " + (operand1 * operand2) + "\n");
                            break;
                        case "/":

                            if (!operand2.equals(0.0)) {
                                System.out.println(operand1 + " / " + operand2 + " = " + (operand1 / operand2) + "\n");
                            } else {
                                System.out.println(ZERO_DIVISION);
                                continue;
                            }
                            break;
                    }
                } catch (AbortException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double getNumber(BufferedReader reader) throws AbortException {

        String stringFromConsole;
        try {
            while ((stringFromConsole = reader.readLine()) != null) {
                if (!stringFromConsole.equalsIgnoreCase(FINISH_APPLICATION)) {
                    try {
                        return Double.parseDouble(stringFromConsole);
                    } catch (NumberFormatException e) {
                        System.out.println(NUMBER_CONTROL_MESSAGE);
                    }
                } else {
                    throw new AbortException();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    private static String getOperationType(BufferedReader reader) throws AbortException {

        String stringFromConsole;
        try {
            while ((stringFromConsole = reader.readLine()) != null) {
                if (stringFromConsole.equals("+") ||
                        stringFromConsole.equals("-") ||
                        stringFromConsole.equals("/") ||
                        stringFromConsole.equals("*")
                ) {
                    return stringFromConsole;
                } else if (stringFromConsole.equalsIgnoreCase(FINISH_APPLICATION)) {
                    throw new AbortException();
                } else {
                    System.out.println("Wrong operation type");
                    continue;
                }
            }
        } catch (
                IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    static class AbortException extends Exception {

    }
}
