package Homework4.Factories;


import Homework4.CarInfo.CarInfo;
import Homework4.CarInfo.RegularCarInfo;
import Homework4.Cars.Car;
import Homework4.Cars.RegularCar;
import Homework4.Enums.CarInterfaces.CarColors;
import Homework4.Enums.CarInterfaces.CarEngines;
import Homework4.Enums.CarInterfaces.CarModels;
import Homework4.Enums.CarInterfaces.CarWheels;
import Homework4.Enums.Options;
import Homework4.Enums.RegularCar.*;
import Homework4.Service.ServiceList;

import java.util.Random;

public class RegularCarFactory extends Factory<RegularCar> {

    public RegularCarFactory(String factoryName, ServiceList services, RegularCarModels[] models, RegularCarColors[] colors,
                             RegularCarEngines[] engines, RegularCarWheels[] wheels) {
        super(factoryName, services, models, colors, engines, wheels);

        for (int i = 0; i < 5; i++) {
            storage.add((RegularCar) createCar(RegularCarModels.values()[new Random().nextInt(RegularCarModels.values().length)]
                    , RegularCarColors.values()[new Random().nextInt(RegularCarColors.values().length)]
                    , RegularCarEngines.values()[new Random().nextInt(RegularCarEngines.values().length)]
                    , RegularCarWheels.values()[new Random().nextInt(RegularCarWheels.values().length)]
                    , new Options[]{Options.values()[new Random().nextInt(Options.values().length)]}
                    , new RegularCarInfo(RegularCarType.values()[new Random().nextInt(RegularCarType.values().length)])));
        }
    }

    public RegularCarFactory(String factoryName, ServiceList services) {
        this(factoryName, services, RegularCarModels.values(), RegularCarColors.values(), RegularCarEngines.values(), RegularCarWheels.values());
    }

    @Override
    Car checkCarInStorage(CarModels model, CarColors color, CarEngines engine, CarWheels wheels, Options[] options, CarInfo carInfo) {
        Car regularCarInStorage = null;
        int previousChanges = Integer.MAX_VALUE;
        synchronized (storage) {
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
        }
        return regularCarInStorage;
    }


    @Override
    Car createCar(CarModels model, CarColors color, CarEngines engine, CarWheels wheels, Options[] options, CarInfo carInfo) {
        int year = getYear();
        RegularCarInfo regularCarInfo = (RegularCarInfo) carInfo;
        RegularCarType regularCarType = regularCarInfo.getCarDoors();
        return new RegularCar((RegularCarColors) color, (RegularCarModels) model, year, (RegularCarWheels) wheels, (RegularCarEngines) engine, options, regularCarType);
    }
}
