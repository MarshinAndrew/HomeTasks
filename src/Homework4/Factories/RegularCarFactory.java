package Homework4.Factories;


import Homework4.CarInfo.CarInfo;
import Homework4.CarInfo.RegularCarInfo;
import Homework4.Cars.Car;
import Homework4.Cars.RegularCar;
import Homework4.Enums.Options;
import Homework4.Enums.RegularCar.*;
import Homework4.Service.ServiceList;

import java.util.Random;

public class RegularCarFactory extends Factory<RegularCar, CarModels, CarColors, CarEngines, CarWheels> {

    public RegularCarFactory(String factoryName, ServiceList services, CarModels[] models, CarColors[] colors,
                             CarEngines[] engines, CarWheels[] wheels) {
        super(factoryName, services, models, colors, engines, wheels);

        for (int i = 0; i < 5; i++) {
            storage.add((RegularCar) createCar(CarModels.values()[new Random().nextInt(CarModels.values().length)]
                    , CarColors.values()[new Random().nextInt(CarColors.values().length)]
                    , CarEngines.values()[new Random().nextInt(CarEngines.values().length)]
                    , CarWheels.values()[new Random().nextInt(CarWheels.values().length)]
                    , new Options[]{Options.values()[new Random().nextInt(Options.values().length)]}
                    , new RegularCarInfo(CarDoors.values()[new Random().nextInt(CarDoors.values().length)])));
        }
    }

    public RegularCarFactory(String factoryName,ServiceList services) {
        this(factoryName, services, CarModels.values(), CarColors.values(), CarEngines.values(), CarWheels.values());
    }

    @Override
    Car checkCarInStorage(CarModels model, CarColors color, CarEngines engine, CarWheels wheels, Options[] options, CarInfo carInfo) {
        Car regularCarInStorage = null;
        int previousChanges = Integer.MAX_VALUE;

        for (RegularCar car : storage) {
            RegularCarInfo regularCarInfo = (RegularCarInfo) carInfo;
            if (car.getModel().equals(model)
                    && car.getEngineVol().equals(engine)
                    && car.getCarDoors().equals(regularCarInfo.getCarDoors())) {
                int currentChanges = findSuitableCar(car, color, wheels, options);
                if (currentChanges == 0) {
                    return car;
                } else {
                    if (currentChanges < previousChanges) {
                        regularCarInStorage = car;
                    }
                }
            }
        }
        return regularCarInStorage;
    }


    @Override
    Car createCar(CarModels model, CarColors color, CarEngines engine, CarWheels wheels, Options[] options, CarInfo carInfo) {
        int year = getYear();
        RegularCarInfo regularCarInfo = (RegularCarInfo) carInfo;
        CarDoors carDoors = regularCarInfo.getCarDoors();
        return new RegularCar(color, model, year, wheels, engine, options, carDoors);
    }
}
