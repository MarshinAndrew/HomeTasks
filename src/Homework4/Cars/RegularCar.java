package Homework4.Cars;

import Homework4.Enums.*;
import Homework4.Enums.RegularCar.*;

import java.util.Set;

public class RegularCar extends Car<CarColors, CarModels, CarWheels, CarEngines> {

    private final CarDoors carDoors;

    public RegularCar(CarColors color, CarModels model, int year, CarWheels wheelSize, CarEngines engineVol, Options[] options, CarDoors carDoors) {
        super(color, model, year, wheelSize, engineVol, options);
        this.carDoors = carDoors;
    }

    public RegularCar(CarColors color, CarModels model, int year, CarWheels wheelSize, CarEngines engineVol, CarDoors carDoors) {
        super(color, model, year, wheelSize, engineVol);
        this.carDoors = carDoors;
    }

    public CarDoors getCarDoors() {
        return carDoors;
    }

    @Override
    public String toString() {
        return "RegularCar{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", carDoors=" + carDoors +
                '}';
    }
}
