package Homework3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private final Brand brand;
    private final Engine engine;
    private final int year;
    private Color color;
    private Wheels wheels;
    private List<Options> options = new ArrayList<>();


    public Car(Brand brand, Engine engine, int year, Color color, Wheels wheels, List<Options> options) {
        this.brand = brand;
        this.engine = engine;
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        if (options != null) {
            for (Options option : options) {
                this.options.add(option);
            }
        }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }


    public Brand getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getYear() {
        return year;
    }

    public Color getColor() {
        return color;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public List<Options> getOptions() {
        return options;
    }


    @Override
    public String toString() {
        return brand.name() + " " + year + " " + engine.name() + " " + color.name() + " " + wheels.name() +
                " Options " + options;
    }
}
