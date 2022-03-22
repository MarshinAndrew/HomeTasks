package Homework4.Service;

import Homework4.Cars.Car;
import Homework4.Enums.Options;

public class AddOptionService implements Serviceable{

    @Override
    public <T extends Car, V> void makeOperation(T car, V e) throws ClassCastException, NullPointerException {

        if (car == null
                || e == null) {
            throw new NullPointerException();
        }

        if(!car.getOptions().contains(e)){
            car.addOption((Options) e);
        }

    }
}
