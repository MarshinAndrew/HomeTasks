package Homework5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task5_Matrix_Multiplication {
    public static void main(String[] args) {

        String fileName = "matrix";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            Double[][] matrix1 = Task2_Matrix_Multiplication.createMatrix(3, 3, reader);
            Task2_Matrix_Multiplication.printMatrix(matrix1);

            Double[][] matrix2 = Task2_Matrix_Multiplication.createMatrix(3, 3, reader);
            Task2_Matrix_Multiplication.printMatrix(matrix2);

            Double[][] matrix3 = Task2_Matrix_Multiplication.multiplyMatrix(matrix1, matrix2);
            Task2_Matrix_Multiplication.printMatrix(matrix3);

        } catch (FileNotFoundException | NullPointerException | ArithmeticException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }


    }
}
