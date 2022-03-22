package Homework4;

import Homework4.CarInfo.BusInfo;
import Homework4.CarInfo.CarInfo;
import Homework4.CarInfo.RegularCarInfo;
import Homework4.CarInfo.TruckInfo;
import Homework4.Cars.Bus;
import Homework4.Cars.Car;
import Homework4.Cars.RegularCar;
import Homework4.Cars.Truck;
import Homework4.Enums.BusEnums.*;
import Homework4.Enums.Options;
import Homework4.Enums.RegularCar.*;
import Homework4.Enums.TruckEnums.*;
import Homework4.Exceptions.CarValidationException;
import Homework4.Exceptions.FactoryNotFoundException;
import Homework4.Factories.BusFactory;
import Homework4.Factories.Factory;
import Homework4.Factories.RegularCarFactory;
import Homework4.Factories.TruckFactory;
import Homework4.Service.*;

import java.util.Arrays;
import java.util.List;

public class Salon {

    private List<Serviceable> services;
    private List<Factory> factories;

    public Salon(ServiceList services, List<Factory> factories) {
        this.services = services.getServiceList();
        this.factories = factories;
    }

    public Bus orderBus(BusModels model, BusColors color, BusEngines engine,
                        BusWheels wheels, BusSeats busSeats, Options... options) throws FactoryNotFoundException, NullPointerException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || busSeats == null) {
            throw new NullPointerException();
        }

        CarInfo busInfo = new BusInfo(busSeats);

        for (Factory factory : factories) {
            if (factory instanceof BusFactory) {
                try {
                    return (Bus) factory.orderCar(model, color, engine, wheels, options, busInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException("No factories available for this order");
    }

    public Truck orderTuck(TruckModels model, TruckColors color, TruckEngines engine,
                           TruckWheels wheels, TruckTonnage tonnage, Options... options) throws FactoryNotFoundException, NullPointerException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || tonnage == null) {
            throw new NullPointerException();
        }

        CarInfo truckInfo = new TruckInfo(tonnage);

        for (Factory factory : factories) {
            if (factory instanceof TruckFactory) {
                try {
                    return (Truck) factory.orderCar(model, color, engine, wheels, options, truckInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException();
    }

    public RegularCar orderRegularCar(CarModels model, CarColors color, CarEngines engine,
                                      CarWheels wheels, CarDoors carDoors, Options... options) throws FactoryNotFoundException, NullPointerException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || carDoors == null) {
            throw new NullPointerException();
        }

        CarInfo carInfo = new RegularCarInfo(carDoors);

        for (Factory factory : factories) {
            if (factory instanceof RegularCarFactory) {
                try {
                    return (RegularCar) factory.orderCar(model, color, engine, wheels, options, carInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException();
    }

    public void serviceBus(Bus bus, BusColors color, BusWheels busWheels, boolean addOrDeleteOptions, Options... options) {
        if (bus == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(bus, color);
        }

        if (busWheels != null) {
            changeWheels(bus, busWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(bus, options);
            } else {
                deleteOption(bus, options);
            }
        }
    }

    public void serviceRegularCar(RegularCar car, BusColors color, CarWheels carWheels, boolean addOrDeleteOptions, Options... options) {
        if (car == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(car, color);
        }

        if (carWheels != null) {
            changeWheels(car, carWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(car, options);
            } else {
                deleteOption(car, options);
            }
        }
    }

    public void serviceTruck(Truck truck, TruckColors color, TruckWheels truckWheels, boolean addOrDeleteOptions, Options... options) {
        if (truck == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(truck, color);
        }

        if (truckWheels != null) {
            changeWheels(truck, truckWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(truck, options);
            } else {
                deleteOption(truck, options);
            }
        }
    }

    private <T extends Car> void changeColor(T car, Enum color) {

        services.stream().filter(serviceable -> serviceable instanceof ColorService).findFirst().get().makeOperation(car, color);
    }

    private <T extends Car> void changeWheels(T car, Enum wheels) {

        services.stream().filter(serviceable -> serviceable instanceof WheelService).findFirst().get().makeOperation(car, wheels);
    }

    private <T extends Car> void addOption(T car, Enum... option) {

        Serviceable service = services.stream().filter(serviceable -> serviceable instanceof AddOptionService).findFirst().get();
        Arrays.stream(option).forEach(o -> service.makeOperation(car, o));
    }

    private <T extends Car> void deleteOption(T car, Enum... option) {

        Serviceable service = services.stream().filter(serviceable -> serviceable instanceof DeleteOptionService).findFirst().get();
        Arrays.stream(option).forEach(o -> service.makeOperation(car, o));
    }

    public void addFactory(Factory factory){
        factories.add(factory);
    }

    public void removeFactory(Factory factory){
        factories.remove(factory);
    }


}
