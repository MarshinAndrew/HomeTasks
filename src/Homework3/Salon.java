package Homework3;


import java.util.ArrayList;
import java.util.List;

public class Salon {

    private Factory factory;
    private CarService carService;

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public Car orderCar(Brand brand, Engine engine, Color color, Wheels wheels, Options... options) {
        Car car;
        List<Options> orderOptions = new ArrayList<>();
        if (options != null) {
            for (Options option : options) {
                orderOptions.add(option);
            }
        }
        return car = factory.orderCar(brand, engine, color, wheels, orderOptions);
    }
}
