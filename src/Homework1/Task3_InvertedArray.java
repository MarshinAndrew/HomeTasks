package Homework1;

import java.util.Arrays;

public class Task3_InvertedArray {
    public static void main(String[] args) {

        MatrixCreation matrixCreation = new MatrixCreation(100, 10, true);
        int[] array = matrixCreation.generateRandomIntArray(10);

        System.out.println("Array");
        System.out.println(Arrays.toString(array));

        System.out.println("Inverted array");
        System.out.println(Arrays.toString(ArrayOperations.invertArray(array)));

    }
}
