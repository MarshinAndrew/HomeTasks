package Homework4;

import Homework4.Cars.Bus;
import Homework4.Cars.RegularCar;
import Homework4.Cars.Truck;
import Homework4.Enums.BusEnums.*;
import Homework4.Enums.Options;
import Homework4.Enums.RegularCar.*;
import Homework4.Enums.TruckEnums.*;
import Homework4.Exceptions.FactoryNotFoundException;
import Homework4.Factories.BusFactory;
import Homework4.Factories.Factory;
import Homework4.Factories.RegularCarFactory;
import Homework4.Factories.TruckFactory;
import Homework4.Service.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServiceList serviceList = new ServiceList();

        Factory busFactory1 = new BusFactory("Bus factory 1", serviceList);
        Factory truckFactory1 = new TruckFactory("Truck factory 1", serviceList);
        Factory regularCarFactory1 = new RegularCarFactory("Car factory 1", serviceList);

        List<Factory> factoryList1 = new ArrayList<>();
        factoryList1.add(busFactory1);
        factoryList1.add(truckFactory1);
        factoryList1.add(regularCarFactory1);

        Salon salon1 = new Salon(serviceList, factoryList1);


        busFactory1.info();
        busFactory1.showStorage();
        try {
            System.out.println();
            Bus bus = salon1.orderBus(BusModels.NEOPLAN, BusColors.BLACK, BusEngines.BUS_ENGINE_1
            , BusWheels.R20, BusSeats.MEDIUM, Options.RADIO);
            System.out.println(bus + "\n");
            busFactory1.showStorage();
            salon1.serviceBus(bus, null, BusWheels.R25, true, null);
            System.out.println(bus + "\n");
            salon1.serviceBus(bus, null, BusWheels.R25, true, Options.NAVIGATOR);
            System.out.println(bus + "\n");
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        truckFactory1.info();
        truckFactory1.showStorage();
        try {
            System.out.println();
            Truck truck = salon1.orderTuck(TruckModels.MAZ, TruckColors.WHITE, TruckEngines.TRUCK_ENGINE_2
                    , TruckWheels.R40, TruckTonnage.REGULAR_LOAD,Options.ABS,Options.RADIO);
            System.out.println(truck + "\n");
            regularCarFactory1.showStorage();
            salon1.serviceTruck(truck, TruckColors.BLACK, TruckWheels.R30, true, Options.NAVIGATOR);
            System.out.println(truck + "\n");

        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        regularCarFactory1.info();
        regularCarFactory1.showStorage();
        try {
            System.out.println();
            RegularCar car = salon1.orderRegularCar(CarModels.VW, CarColors.BLACK, CarEngines.CAR_ENGINE_1
                    , CarWheels.R15, CarDoors.REGULAR);
            System.out.println(car + "\n");
            regularCarFactory1.showStorage();
            salon1.serviceRegularCar(car, null, null, true, null);
            System.out.println(car + "\n");
            salon1.serviceRegularCar(car, null, CarWheels.R17, true, Options.NAVIGATOR, Options.RADIO);
            System.out.println(car + "\n");
            salon1.serviceRegularCar(car, null, CarWheels.R17, false, Options.NAVIGATOR);
            System.out.println(car + "\n");
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        Factory busFactory2 = new BusFactory("Bus factory 2"
                , serviceList
                , new BusModels[]{BusModels.IVECO}
                , new BusColors[]{BusColors.WHITE}
                , new BusEngines[]{BusEngines.BUS_ENGINE_1}
                , new BusWheels[]{BusWheels.R20});


        List<Factory> factoryList2 = new ArrayList<>();
        factoryList1.add(busFactory2);
        Salon salon2 = new Salon(serviceList, factoryList2);

        try {
            System.out.println();
            Bus bus = salon2.orderBus(BusModels.NEOPLAN, BusColors.BLACK, BusEngines.BUS_ENGINE_1, BusWheels.R20, BusSeats.MEDIUM, Options.RADIO);
            System.out.println(bus);
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }


    }


}

