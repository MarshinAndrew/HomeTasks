package Homework4.Cars;


import Homework4.Enums.*;
import Homework4.Enums.BusEnums.*;
import Homework4.Enums.CarInterfaces.CarColors;
import Homework4.Enums.CarInterfaces.CarWheels;
import Homework4.Exceptions.CarParameterException;

public class Bus extends Car {

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
    public void setColor(CarColors color) throws CarParameterException{

        if(color instanceof BusColors){
            this.color=color;
        }else{
            throw new CarParameterException();
        }
    }

    @Override
    public void setWheelSize(CarWheels wheelSize) throws CarParameterException {
        if(wheelSize instanceof BusWheels){
            this.wheelSize=wheelSize;
        }else{
            throw new CarParameterException();
        }
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
