package Homework1;

public class MatrixCreation {

    private int maxArrayLength;
    private int maxNumber;
    private boolean enableSign;


    public MatrixCreation() {
        this(10, 10, false);
    }
    public MatrixCreation(int maxArrayLength, int maxNumber, boolean enableSign) {
        this.maxArrayLength = maxArrayLength;
        this.maxNumber = maxNumber;
        this.enableSign = enableSign;

    }

    public int[] generateRandomIntArray(int arrayLength) {

        int[] newArray = null;

        if (arrayLengthCheck(arrayLength)) {
            newArray = new int[arrayLength];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = (int) (Math.random() * sign() * maxNumber);
            }
        }
        return newArray;
    }

    public int[][] generateRandomTwoDimensionArray(int maxArraySize) {

        int[][] twoDimensionArray = null;

        if (arrayLengthCheck(maxArraySize)) {
             twoDimensionArray = new int[(int) (Math.random() * maxArraySize)][];
            for (int i = 0; i < twoDimensionArray.length; i++) {
                twoDimensionArray[i] = generateRandomIntArray((int) (Math.random() * maxArraySize));
            }
        }
        return twoDimensionArray;
    }

    public int[][] generateRandomRectangularMatrix(int rows, int columns) {

        int[][] rectangularMatrix = null;

        if (arrayLengthCheck(rows)&& arrayLengthCheck(columns)) {
            rectangularMatrix = new int[rows][columns];
            for (int i = 0; i < rectangularMatrix.length; i++) {
                rectangularMatrix[i] = generateRandomIntArray(columns);
            }
        }
        return rectangularMatrix;
    }

    private int sign() {
        int sign = (this.enableSign && Math.round(Math.random()) == 1) ? -1 : 1;
        return sign;
    }

    private boolean arrayLengthCheck(int arrayLength) {
        if (arrayLength >= 0 && arrayLength <= maxArrayLength) {
            return true;
        } else {
            System.out.println("Array lengths is out of range, array wasn't generated. ");
            System.out.println("Permissible array lengths from 0 to " + maxArrayLength + ".\n");
            return false;
        }

    }


    public int getMaxArrayLength() {
        return maxArrayLength;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public boolean isEnableSign() {
        return enableSign;
    }

    public boolean setMaxArrayLength(int maxArrayLength) {
        if (maxArrayLength > 0) {
            this.maxArrayLength = maxArrayLength;
            return true;
        }
        return false;
    }

    public boolean setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        return true;
    }

    public boolean setEnableSign(boolean enableSign) {
        this.enableSign = enableSign;
        return true;
    }
}
