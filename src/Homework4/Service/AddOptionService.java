package Homework4.Service;

import Homework4.Cars.Car;
import Homework4.Enums.Options;

public class AddOptionService implements Serviceable<Car, Options> {

    @Override
    public void makeOperation(Car car, Options options) {

        if (car == null
                || options == null) {
            throw new NullPointerException();
        }

        if (!car.getOptions().contains(options)) {
            car.addOption(options);
        }

    }
}
