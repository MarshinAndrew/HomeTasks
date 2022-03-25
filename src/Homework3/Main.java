package Homework3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CarService service = new Service();

        Brand[] factoryBrands = {Brand.AUDI};
        Engine[] factoryEngines = {Engine.GAS1_2, Engine.GAS2_0};
        Color[] factoryColors = {Color.BLACK, Color.GREEN, Color.RED};
        Wheels[] factoryWheels = {Wheels.R16, Wheels.R17};
        Options[] factoryOptions = {Options.AUDIOSYSTEM, Options.NAVIGATOR};


        Factory factory = new Factory(factoryBrands, factoryEngines, factoryColors, factoryWheels, factoryOptions);
        factory.setCarService(service);

        System.out.println(factory.getBrands());
        System.out.println(factory.getEngines());
        System.out.println(factory.getColors());
        System.out.println(factory.getWheels());
        System.out.println(factory.getOptions());
        System.out.println(factory.getWarehouse());
        Salon salon = new Salon();
        salon.setFactory(factory);
        salon.setCarService(service);


        Car car = salon.orderCar(Brand.AUDI, Engine.GAS1_2, Color.GREEN, Wheels.R17, Options.NAVIGATOR);
        System.out.println(car);

        System.out.println(factory.getWarehouse());
    }


}





