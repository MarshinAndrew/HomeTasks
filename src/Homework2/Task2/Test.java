package Homework2.Task2;

public class Test {
    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(2, 3);
        Box box3 = new Box(1, 2, 3);
        System.out.println(box1.boxType());
        System.out.println(box2.boxType());
        System.out.println(box3.boxType());
    }
}
