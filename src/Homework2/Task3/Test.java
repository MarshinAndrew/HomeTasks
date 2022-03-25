package Homework2.Task3;

import Homework2.Task2.Box;

public class Test {
    public static void main(String[] args) {
        NumbersContainer container = new NumbersContainer();
        System.out.println(container.getAverageValue());
        container.addNumber(2);
        container.addNumber(4);
        System.out.println(container.getAverageValue());
        container.addNumber(6);
        container.addNumber(5.5);
        System.out.println(container.getAverageValue());
        container.addNumber(5);
        System.out.println(container.getAverageValue());
        container.addNumber(5);
        System.out.println(container.getAverageValue());

    }
}
