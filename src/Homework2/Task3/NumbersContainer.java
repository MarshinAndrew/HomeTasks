package Homework2.Task3;

public class NumbersContainer {

    private double[] container = new double[5];
    private int index;
    private boolean containerFull;

    public void addNumber(double number) {
        container[index] = number;
        index++;
        if (index == container.length) {
            containerFull = true;
            index = 0;
        }
    }

    public double getAverageValue() {
        double sum = 0;
        if (index == 0 && !containerFull) {
            return 0;
        } else {
            for (double element : container) {
                sum += element;
            }
            return (containerFull) ? sum / container.length : sum / index;
        }
    }
}
