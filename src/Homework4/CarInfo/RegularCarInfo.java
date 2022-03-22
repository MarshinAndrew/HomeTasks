package Homework4.CarInfo;

import Homework4.Enums.RegularCar.CarDoors;

public class RegularCarInfo extends CarInfo{

    private final CarDoors carDoors;

    public RegularCarInfo(CarDoors carDoors) {
        this.carDoors = carDoors;
    }

    public CarDoors getCarDoors() {
        return carDoors;
    }
}
