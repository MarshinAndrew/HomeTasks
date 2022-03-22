package Homework4.Service;

import Homework4.Cars.Car;

import java.util.Arrays;
import java.util.HashSet;


public class ColorService implements Serviceable {

    @Override
    public <T extends Car, V > void makeOperation(T car, V e)  {

        if (car == null
                || e == null) {
            throw new NullPointerException();
        }

        if (!car.getColor().equals(e)) {
            car.setColor(e);
        }

    }
}
