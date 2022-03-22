package Homework4.Cars;

import Homework4.Enums.Options;
import Homework4.Enums.TruckEnums.*;



public class Truck extends Car<TruckColors, TruckModels, TruckWheels, TruckEngines> {

    private final TruckTonnage tonnage;

    public Truck(TruckColors color, TruckModels model, int year, TruckWheels wheelSize, TruckEngines engineVol, Options[] options, TruckTonnage tonnage) {
        super(color, model, year, wheelSize, engineVol, options);
        this.tonnage = tonnage;
    }

    public Truck(TruckColors color, TruckModels model, int year, TruckWheels wheelSize, TruckEngines engineVol, TruckTonnage tonnage) {
        super(color, model, year, wheelSize, engineVol);
        this.tonnage = tonnage;
    }

    public TruckTonnage getTonnage() {
        return tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", tonnage=" + tonnage +
                '}';
    }
}
