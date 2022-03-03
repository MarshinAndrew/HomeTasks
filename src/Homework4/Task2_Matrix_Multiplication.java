package Homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task2_Matrix_Multiplication {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Double[][] matrix1 = createMatrix(2, 3, reader);
            printMatrix(matrix1);
            Double[][] matrix2 = createMatrix(3, 2, reader);
            printMatrix(matrix2);
            Double[][] matrix3 = multiplyMatrix(matrix1, matrix2);
            printMatrix(matrix3);
        } catch (NullPointerException | ArithmeticException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }

    }

    public static Double[][] createMatrix(int rowsNumber, int columnsNumber, BufferedReader reader) throws NullPointerException {

        if (reader == null) {
            throw new NullPointerException("Input stream is null!!!");
        }
        Queue<String> stringsFromReader = new PriorityQueue<>();
        Double[][] matrix = new Double[rowsNumber][columnsNumber];
        String string;
        for (Double[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                try {
                    while (true) {
                        if (stringsFromReader.isEmpty()) {
                            if ((string = reader.readLine()) != null) {
                                if (!string.equals("")) {
                                    Collections.addAll(stringsFromReader, string.split(" "));
                                } else {
                                    continue;
                                }
                            } else {
                                row[i] = 0.0;
                                break;
                            }
                        }
                        try {
                            row[i] = Double.parseDouble(stringsFromReader.poll());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Only numbers available");
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
                }
            }
        }
        return matrix;
    }

    public static Double[][] multiplyMatrix(Double[][] matrix1, Double[][] matrix2) throws NullPointerException, ArithmeticException {

        if (matrix1 == null || matrix2 == null) {
            throw new NullPointerException("Input parameter is null!!!");
        }

        if (matrix1[0].length != matrix2.length) {
            throw new ArithmeticException("Invalid matrix sizes");
        }

        Double[][] resultMatrix = new Double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                resultMatrix[i][j] = 0.0;
                for (int k = 0; k < matrix2.length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public static <T> void printMatrix(T[][] matrix) {
        for (T[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println();

    }
}
