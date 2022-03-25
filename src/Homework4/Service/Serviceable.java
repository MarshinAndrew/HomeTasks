package Homework4.Service;


import Homework4.Cars.Car;
import Homework4.Enums.CarInterfaces.CarParameter;
import Homework4.Exceptions.CarParameterException;


public interface Serviceable<T extends Car, V extends CarParameter>  {
    void makeOperation(T car, V e) throws CarParameterException;
}
