package Homework4.Cars;

import Homework4.Enums.*;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Car<T, V, E, S> {

    protected T color;
    protected final V model;
    protected final int year;
    protected E wheelSize;
    protected final S engineVol;
    protected Set<Options> options;

    public Car(T color, V model, int year, E wheelSize, S engineVol, Options[] options) {
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

    public Car(T color, V model, int year, E wheelSize, S engineVol) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVol = engineVol;
        this.options = new HashSet<>();
    }

    public void setColor(T color) {
        this.color = color;
    }

    public void setWheelSize(E wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    public void addOption(Options option) {
        options.add(option);
    }

    public void removeOption(Options option) {
        options.remove(option);
    }

    public T getColor() {
        return color;
    }

    public V getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public E getWheelSize() {
        return wheelSize;
    }

    public S getEngineVol() {
        return engineVol;
    }

    public Set<Options> getOptions() {
        return options;
    }

}
