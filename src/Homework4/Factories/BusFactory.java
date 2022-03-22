package Homework4.Factories;


import Homework4.CarInfo.BusInfo;
import Homework4.Cars.Bus;
import Homework4.Cars.Car;
import Homework4.CarInfo.CarInfo;
import Homework4.Enums.BusEnums.*;
import Homework4.Enums.Options;
import Homework4.Service.ServiceList;


import java.util.*;

public class BusFactory extends Factory<Bus, BusModels, BusColors, BusEngines, BusWheels> {

    public BusFactory(String factoryName, ServiceList services, BusModels[] models, BusColors[] colors,
                      BusEngines[] engines, BusWheels[] wheels) {
        super(factoryName, services, models, colors, engines, wheels);

        for (int i = 0; i < 5; i++) {
            storage.add((Bus) createCar(BusModels.values()[new Random().nextInt(BusModels.values().length)]
                    , BusColors.values()[new Random().nextInt(BusColors.values().length)]
                    , BusEngines.BUS_ENGINE_1
                    , BusWheels.values()[new Random().nextInt(BusWheels.values().length)]
                    , new Options[]{Options.values()[new Random().nextInt(Options.values().length)]}
                    , new BusInfo(BusSeats.MEDIUM)));
        }

    }

    public BusFactory(String factoryName, ServiceList services) {
        this(factoryName, services, BusModels.values(), BusColors.values(), BusEngines.values(), BusWheels.values());

    }

    @Override
    Car checkCarInStorage(BusModels model, BusColors color, BusEngines engine, BusWheels wheels, Options[] options, CarInfo carInfo) {

        Car busInStorage = null;
        int previousChanges = Integer.MAX_VALUE;

        for (Bus bus : storage) {
            BusInfo busInfo = (BusInfo) carInfo;
            if (bus.getModel().equals(model)
                    && bus.getEngineVol().equals(engine)
                    && bus.getSeatsNumber() == busInfo.getSeatsInfo().getSeatsNumber()) {
                int currentChanges = findSuitableCar(bus, color, wheels, options);
                if (currentChanges == 0) {
                    return bus;
                } else {
                    if (currentChanges < previousChanges) {
                        busInStorage = bus;
                    }
                }
            }
        }
        return busInStorage;
    }

    @Override
    Car createCar(BusModels model, BusColors color, BusEngines engine, BusWheels wheels, Options[] options, CarInfo carInfo) {
        int year = getYear();
        BusInfo busInfo = (BusInfo) carInfo;
        BusSeats seatNumber = busInfo.getSeatsInfo();
        return new Bus(color, model, year, wheels, engine, options, seatNumber);
    }
}
