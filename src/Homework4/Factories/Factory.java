package Homework4.Factories;


import Homework4.Cars.Car;
import Homework4.CarInfo.CarInfo;
import Homework4.Enums.Options;
import Homework4.Exceptions.CarValidationException;
import Homework4.Service.*;

import java.util.*;

public abstract class Factory<T extends Car, W, V, E, S> {

    private final List<Serviceable> services;
    protected final List<T> storage;
    private final Set<W> models;
    private final Set<V> colors;
    private final Set<E> engines;
    private final Set<S> wheels;
    private final String factoryName;
    protected boolean exactCar;

    public Factory(String factoryName, ServiceList services, W[] models, V[] colors, E[] engines, S[] wheels)
            throws NullPointerException {
        if (services == null
                || models == null
                || colors == null
                || engines == null
                || wheels == null) {
            throw new NullPointerException();
        }

        this.factoryName = factoryName;
        this.services = services.getServiceList();
        this.models = new HashSet(Arrays.asList(models));
        this.colors = new HashSet(Arrays.asList(colors));
        this.engines = new HashSet(Arrays.asList(engines));
        this.wheels = new HashSet(Arrays.asList(wheels));
        storage = new ArrayList<>();
    }

    public Car orderCar(W model, V color, E engine, S wheels, Options[] options, CarInfo carInfo)
            throws CarValidationException, NullPointerException {
        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || carInfo == null) {
            throw new NullPointerException();
        }
        if (options == null) {
            options = new Options[0];
        }

        Car carInStorage = null;

        if (orderValidation(model, color, engine, wheels)) {
            carInStorage = checkCarInStorage(model, color, engine, wheels, options, carInfo);
            if (carInStorage != null) {
                if (!exactCar) {
                    synchronized (storage) {
                        storage.remove(carInStorage);
                    }
                    serviceCar(carInStorage, color, wheels, options);
                    return carInStorage;
                }
                return carInStorage;
            } else {
                exactCar = true;
                return createCar(model, color, engine, wheels, options, carInfo);
            }
        } else {
            throw new CarValidationException();
        }
    }


    private boolean orderValidation(W model, V color, E engine, S wheels) {
        return models.contains(model)
                && colors.contains(color)
                && engines.contains(engine)
                && this.wheels.contains(wheels);
    }

    abstract Car checkCarInStorage(W model, V color, E engine, S wheels, Options[] options, CarInfo carInfo);

    protected int findSuitableCar(Car car, V color, S wheels, Options[] options) {

        int changesToDo = 0;

        if (!car.getColor().equals(color)) {
            changesToDo++;
            if (!car.getWheelSize().equals(wheels)) {
                changesToDo++;
            }
            changesToDo += getNumberOfDifferentOptions(car, options);
        }
        return changesToDo;
    }

    protected int getNumberOfDifferentOptions(Car car, Options[] options) {
        int numberOfDifferentOptions = (int) car.getOptions().stream().filter(carOption -> !Arrays.asList(options).contains(carOption)).count();
        numberOfDifferentOptions += (int) Arrays.stream(options).filter(option -> !car.getOptions().contains(option)).count();
        return numberOfDifferentOptions;
    }

    private void serviceCar(Car car, V color, S wheels, Options[] options) {

        if (!car.getColor().equals(color)) {
            services.stream().filter(serviceable -> serviceable instanceof ColorService).findFirst().get().makeOperation(car, color);
        }

        if (!car.getWheelSize().equals(wheels)) {
            services.stream().filter(serviceable -> serviceable instanceof WheelService).findFirst().get().makeOperation(car, wheels);
        }

        List<Options> optionsToDelete = car.getOptions().stream().filter(option -> !Arrays.asList(options).contains(option)).toList();
        if (optionsToDelete.size() > 0) {
            Serviceable serviceToDeleteOptions = services.stream().filter(serviceable -> serviceable instanceof DeleteOptionService)
                    .findFirst().get();
            optionsToDelete.stream().forEach(options1 -> serviceToDeleteOptions.makeOperation(car, options1));
        }

        List<Options> optionsToAdd = Arrays.stream(options).filter(option -> !car.getOptions().contains(option)).toList();
        if (optionsToAdd.size() > 0) {
            Serviceable serviceToAddOptions = services.stream().filter(serviceable -> serviceable instanceof AddOptionService)
                    .findFirst().get();
            optionsToAdd.stream().forEach(options1 -> serviceToAddOptions.makeOperation(car, options1));
        }
    }

    abstract Car createCar(W model, V color, E engine, S wheels, Options[] options, CarInfo carInfo);

    protected int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public void showStorage() {
        System.out.println(factoryName + " contains " + storage.size() + " cars");
        storage.stream().forEach(car -> System.out.println(car.toString()));
        System.out.println("------------------");
    }

    public void info() {
        System.out.println(factoryName + " info:");
        System.out.println("available models " + models);
        System.out.println("available colors " + colors);
        System.out.println("available engines " + engines);
        System.out.println("available wheels " + wheels);
        System.out.println("------------------");
    }

}

