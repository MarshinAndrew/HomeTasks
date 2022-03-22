package Homework4.Cars;


import Homework4.Enums.*;
import Homework4.Enums.BusEnums.*;
import Homework4.Enums.RegularCar.CarColors;
import Homework4.Enums.RegularCar.CarWheels;

import java.util.Set;

public class Bus extends Car<BusColors, BusModels, BusWheels, BusEngines> {

    private final int seatsNumber;

    public Bus(BusColors color, BusModels model, int year, BusWheels wheelSize, BusEngines engineVol, Options[] options, BusSeats seatsNumber) {
        super(color, model, year, wheelSize, engineVol, options);
        this.seatsNumber = seatsNumber.getSeatsNumber();
    }

    public Bus(BusColors color, BusModels model, int year, BusWheels wheelSize, BusEngines engineVol, int seatsNumber) {
        super(color, model, year, wheelSize, engineVol);
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", seatsNumber=" + seatsNumber +
                '}';
    }
}
