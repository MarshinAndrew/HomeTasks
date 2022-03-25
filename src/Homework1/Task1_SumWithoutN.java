package Homework1;

import java.util.Arrays;

public class Task1_SumWithoutN {

    public static void main(String[] args) {

        MatrixCreation matrixCreation = new MatrixCreation(20, 10, false);

        int[] array = matrixCreation.generateRandomIntArray(15);
        System.out.println(Arrays.toString(array));

        int N = (int) (Math.random() * 10);
        ArrayOperations.arraySumWithoutN(array, N);

    }
}
