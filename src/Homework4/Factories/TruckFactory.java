package Homework4.Factories;

import Homework4.CarInfo.CarInfo;
import Homework4.CarInfo.TruckInfo;
import Homework4.Cars.Car;
import Homework4.Cars.Truck;
import Homework4.Enums.Options;
import Homework4.Enums.TruckEnums.*;
import Homework4.Service.ServiceList;
import Homework4.Service.Serviceable;


import java.util.List;
import java.util.Random;

public class TruckFactory extends Factory<Truck, TruckModels, TruckColors, TruckEngines, TruckWheels> {

    public TruckFactory(String factoryName, ServiceList services, TruckModels[] models, TruckColors[] colors,
                        TruckEngines[] engines, TruckWheels[] wheels) {
        super(factoryName, services, models, colors, engines, wheels);

        for (int i = 0; i < 5; i++) {
            storage.add((Truck) createCar(TruckModels.values()[new Random().nextInt(TruckModels.values().length)]
                    , TruckColors.values()[new Random().nextInt(TruckColors.values().length)]
                    , TruckEngines.values()[new Random().nextInt(TruckEngines.values().length)]
                    , TruckWheels.values()[new Random().nextInt(TruckWheels.values().length)]
                    , new Options[]{Options.values()[new Random().nextInt(Options.values().length)]}
                    , new TruckInfo(TruckTonnage.REGULAR_LOAD)));
        }
    }

    public TruckFactory(String factoryName, ServiceList services) {
        this(factoryName, services, TruckModels.values(), TruckColors.values(), TruckEngines.values(), TruckWheels.values());
    }

    @Override
    Car checkCarInStorage(TruckModels model, TruckColors color, TruckEngines engine, TruckWheels wheels
            , Options[] options, CarInfo carInfo) {
        Car truckInStorage = null;
        int previousChanges = Integer.MAX_VALUE;

        for (Truck truck : storage) {
            TruckInfo truckInfo = (TruckInfo) carInfo;
            if (truck.getModel().equals(model)
                    && truck.getEngineVol().equals(engine)
                    && truck.getTonnage().equals(truckInfo.getTonnage())) {
                int currentChanges = findSuitableCar(truck, color, wheels, options);
                if (currentChanges == 0) {
                    return truck;
                } else {
                    if (currentChanges < previousChanges) {
                        truckInStorage = truck;
                    }
                }
            }
        }
        return truckInStorage;
    }

    @Override
    Car createCar(TruckModels model, TruckColors color, TruckEngines engine, TruckWheels wheels
            , Options[] options, CarInfo carInfo) {
        int year = getYear();
        TruckInfo truckInfo = (TruckInfo) carInfo;
        TruckTonnage tonnage = truckInfo.getTonnage();
        return new Truck(color, model, year, wheels, engine, options, tonnage);
    }
}
