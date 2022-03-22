package Homework4.Service;

import Homework4.Cars.Car;


public class WheelService implements Serviceable {

    @Override
    public <T extends Car, V> void makeOperation(T car, V e) {

        if (car == null
                || e == null) {
            throw new NullPointerException();
        }

        if (!car.getWheelSize().equals(e)) {
            car.setWheelSize(e);
        }
    }

}
