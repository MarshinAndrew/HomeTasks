package Homework1;

public class ArrayOperations {


    public static void arraySumWithoutN(int[] array, int N) {

        int arraySum = 0;

        if (isArray(array)) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != N) {
                    if (intSumNotOverflowed(arraySum, array[i])) {
                        arraySum += array[i];
                    } else {
                        System.out.println("Sum wasn't counted correctly, value was overflowed ");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Input parameter is not an array");
            return;
        }
        System.out.println("Array sum without " + N + " is " + arraySum);
    }

    public static void fibonachchiEvenNumbersSum(int finalIndex) {

        int sum = 0;
        int firstValue = 0;
        int secondValue = 1;
        int currentValue = 0;

        for (int i = 2; i < finalIndex; i++) {
            if (intSumNotOverflowed(firstValue, secondValue)) {
                currentValue = firstValue + secondValue;
                if (currentValue % 2 == 0) {
                    sum += currentValue;
                }
                firstValue = secondValue;
                secondValue = currentValue;
            } else {
                System.out.println("Sum wasn't counted correctly, value was overflowed on index " + i);
                return;
            }
        }
        System.out.println("Fibonachchi even numbers sum up to " + finalIndex + " is " + sum);
    }

    public static int[] invertArray(int[] array) {
        if (isArray(array)) {
            int tempVar;
            for (int i = 0; i < array.length / 2; i++) {
                tempVar = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = tempVar;
            }
        } else {
            System.out.println("Input parameter is not an array");
        }
        return array;
    }

    public static void twoDimensionArraySignComparison(int[][] array) {

        int negativeNumbers = 0;
        int positiveNumbers = 0;
        int uncheckedNumbersInArray = numberOfValuesInTwoDimensionArray(array);

        if (uncheckedNumbersInArray > 0) {
            for (int i = 0; i < array.length; i++) {
                if (isArray(array[i])) {
                    for (int j = 0; j < array[i].length; j++) {
                        if (array[i][j] > 0) {
                            positiveNumbers++;
                        } else if (array[i][j] < 0) {
                            negativeNumbers++;
                        }
                        if ((--uncheckedNumbersInArray < Math.abs(positiveNumbers - negativeNumbers)) || uncheckedNumbersInArray == 0) {
                            if (positiveNumbers > negativeNumbers) {
                                System.out.println("Positive numbers more than negative numbers in input array");
                                return;
                            } else if (negativeNumbers > positiveNumbers) {
                                System.out.println("Negative numbers more than positive numbers in input array");
                                return;
                            } else {
                                System.out.println("Positive numbers equals negative numbers in input array");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Input parameter is not two dimension array");
    }

    public static void IsLowerTriangularMatrix(int[][] array) {
        if (isSquareIntMatrix(array)) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i][j] != 0) {
                        System.out.println("Entry matrix is not lower triangular");
                        return;
                    }
                }
            }
            System.out.println("Entry matrix is lower triangular");
            return;
        }
        System.out.println("Entry array is not square matrix");
        return;
    }

    public static int[][] matrixSum(int[][] matrix1, int[][] matrix2) {

        return matrixArithmeticOperations(matrix1, matrix2, '+');
    }

    public static int[][] matrixDifference(int[][] matrix1, int[][] matrix2) {

        return matrixArithmeticOperations(matrix1, matrix2, '-');
    }

    public static int moneyCount(int[] students) {

        int sum = 1;
        int counter = 1;
        int memory = 0;

        for (int i = 0; i < students.length - 1; i++) {
            if (students[i + 1] > students[i]) {
                if (counter < 1) {
                    if (memory != 0) {
                        sum = (-counter >= memory) ? sum + (-counter - memory + 1) : sum;
                    }
                    counter = 1;
                }
                counter++;
                memory = counter;
                sum += counter;
            } else {
                if (students[i + 1] == students[i]) {
                    if (memory != 0) {
                        sum = (-counter >= memory) ? sum + (-counter - memory + 1) : sum;
                        memory = 0;
                    }
                    counter = 0;
                }
                if (counter > 1) {
                    counter = 0;
                }
                counter--;
                sum -= counter;
            }
        }
        return sum;
    }


    private static boolean intSumNotOverflowed(int a, int b) {

        if (Integer.signum(a) != Integer.signum(b) || a == 0 || b == 0) {
            return true;
        }
        if (a > 0 && Integer.MAX_VALUE - a >= b) {
            return true;
        }
        if (a < 0 && Integer.MIN_VALUE - a <= b) {
            return true;
        }
        return false;

    }

    private static boolean isArray(int[] array) {

        return (array != null && array.length > 0) ? true : false;
    }

    private static boolean isSquareIntMatrix(int[][] array) {

        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (!isArray(array[i]) || array[i].length != array.length) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isRectangularIntMatrix(int[][] array) {

        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (!isArray(array[i]) || array[0].length != array[i].length) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static int numberOfValuesInTwoDimensionArray(int[][] array) {

        int numbersInArray = 0;

        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (isArray(array[i])) {
                    numbersInArray += array[i].length;
                }
            }
        }
        return numbersInArray;
    }

    private static int[][] matrixArithmeticOperations(int[][] matrix1, int[][] matrix2, char operation) {
        int[][] resultMatrix = null;

        if (isRectangularIntMatrix(matrix1) && isRectangularIntMatrix(matrix2)) {
            if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
                resultMatrix = new int[matrix1.length][matrix1[0].length];
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[i].length; j++) {
                        switch (operation) {
                            case '+':
                                if (intSumNotOverflowed(matrix1[i][j], matrix2[i][j])) {
                                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                                    break;
                                } else {
                                    System.out.println("Sum wasn't counted correctly, value was overflowed");
                                    return null;
                                }
                            case '-':
                                if (intSumNotOverflowed(matrix1[i][j], -matrix2[i][j])) {
                                    resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                                    break;
                                } else {
                                    System.out.println("Difference wasn't counted correctly, value was overflowed");
                                    return null;

                                }
                            default:
                                System.out.println("No such arithmetical operation");
                                return null;
                        }
                    }
                    return resultMatrix;
                }
            }
            System.out.println(" Matrix need to be the same size ");
            return null;
        }
        System.out.println("Operation available only on rectangular matrix ");
        return null;
    }

    public static void printArray(int[] array) {


        if (isArray(array)) {
            for (int element : array) {
                System.out.printf("%4d\t", element);
            }
        }

    }

    public static void printTwoDimensionArray(int[][] array) {

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                ArrayOperations.printArray(array[i]);
                System.out.println();
            }
        }
    }

}
