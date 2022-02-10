package Homework2.Task4;

public class Test {
    public static void main(String[] args) {
        Car carAudi=new Car("Audi","red");
        System.out.println(carAudi.getColor());

        carAudi.changeColor("green");
        System.out.println(carAudi.getColor());

        carAudi.changeColor("black");
        System.out.println(carAudi.getColor());
    }
}
