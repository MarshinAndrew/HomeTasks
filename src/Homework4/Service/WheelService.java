package Homework4.Service;

import Homework4.Cars.Car;
import Homework4.Enums.CarInterfaces.CarWheels;
import Homework4.Exceptions.CarParameterException;


public class WheelService implements Serviceable<Car, CarWheels> {

    @Override
    public void makeOperation(Car car, CarWheels e) throws CarParameterException {

        if (car == null
                || e == null) {
            throw new NullPointerException();
        }

        if (!car.getWheelSize().equals(e)) {
            car.setWheelSize(e);
        }
    }

}
