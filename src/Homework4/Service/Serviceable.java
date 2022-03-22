package Homework4.Service;

import Homework4.Cars.Car;

public interface Serviceable {
    <T extends Car, V > void makeOperation(T car, V e) throws ClassCastException,NullPointerException;
}
