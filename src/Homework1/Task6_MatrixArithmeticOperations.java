package Homework1;

public class Task6_MatrixArithmeticOperations {
    public static void main(String[] args) {

        MatrixCreation matrixCreation = new MatrixCreation(100, 10, true);


        int[][] matrix1 = matrixCreation.generateRandomRectangularMatrix(5, 3);
        int[][] matrix2 = matrixCreation.generateRandomRectangularMatrix(5, 3);

        System.out.println("Matrix 1");
        ArrayOperations.printTwoDimensionArray(matrix1);

        System.out.println("Matrix 2");
        ArrayOperations.printTwoDimensionArray(matrix2);

        System.out.println("Matrix 1+2");
        ArrayOperations.printTwoDimensionArray(ArrayOperations.matrixSum(matrix1, matrix2));

        System.out.println("Matrix 1-2");
        ArrayOperations.printTwoDimensionArray(ArrayOperations.matrixDifference(matrix1, matrix2));


    }
}
