package Homework4.Service;

import Homework4.Cars.Car;
import Homework4.Enums.CarInterfaces.CarColors;
import Homework4.Exceptions.CarParameterException;


public class ColorService implements Serviceable<Car, CarColors>   {

    @Override
    public void makeOperation (Car car, CarColors color) throws CarParameterException {

        if (car == null
                || color == null) {
            throw new NullPointerException();
        }

        if (!car.getColor().equals(color)) {
            car.setColor(color);
        }
    }
}
