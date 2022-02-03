package Homework1;

public class Task5_LowerTriangularMatrix {
    public static void main(String[] args) {

        MatrixCreation matrixCreation = new MatrixCreation(100, 2, false);

        int[][] matrix = matrixCreation.generateRandomRectangularMatrix(3,3);

        System.out.println("Matrix");
        ArrayOperations.printTwoDimensionArray(matrix);
        ArrayOperations.IsLowerTriangularMatrix(matrix);

    }
}
