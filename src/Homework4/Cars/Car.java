package Homework4.Cars;


import Homework4.Enums.*;
import Homework4.Enums.CarInterfaces.CarColors;
import Homework4.Enums.CarInterfaces.CarEngines;
import Homework4.Enums.CarInterfaces.CarModels;
import Homework4.Enums.CarInterfaces.CarWheels;
import Homework4.Exceptions.CarParameterException;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Car {

    protected CarColors color;
    protected final CarModels model;
    protected final int year;
    protected CarWheels wheelSize;
    protected final CarEngines engineVol;
    protected Set<Options> options;

    public Car(CarColors color, CarModels model, int year, CarWheels wheelSize, CarEngines engineVol, Options[] options) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVol = engineVol;
        if (options != null) {
            this.options = new HashSet<>(Arrays.asList(options));
        } else {
            this.options = new HashSet<>();
        }

    }

    public Car(CarColors color, CarModels model, int year, CarWheels wheelSize, CarEngines engineVol) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVol = engineVol;
        this.options = new HashSet<>();
    }

    public abstract void setColor(CarColors color) throws CarParameterException;

    public abstract void setWheelSize(CarWheels wheelSize) throws CarParameterException;

    public void addOption(Options option) {
        options.add(option) ;
    }

    public void removeOption(Options option) {
        options.remove(option);
    }

    public CarColors getColor() {
        return color;
    }

    public CarModels getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public CarWheels getWheelSize() {
        return wheelSize;
    }

    public CarEngines getEngineVol() {
        return engineVol;
    }

    public Set<Options> getOptions() {
        return options;
    }

}
