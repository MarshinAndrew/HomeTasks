package Homework1;

public class Task4_TwoDimensionArraySignComparison {
    public static void main(String[] args) {

        MatrixCreation matrixCreation = new MatrixCreation(100, 10, true);

        int[][] twoDimensionArray = matrixCreation.generateRandomTwoDimensionArray(10);

        System.out.println("Two dimension int array");
        ArrayOperations.printTwoDimensionArray(twoDimensionArray);

        ArrayOperations.twoDimensionArraySignComparison(twoDimensionArray);

    }
}
