package Homework3;


import java.util.*;

public class Factory {
    private List<Brand> brands = new ArrayList<>();
    private List<Engine> engines = new ArrayList<>();
    private List<Color> colors = new ArrayList<>();
    private List<Wheels> wheels = new ArrayList<>();
    private List<Options> options = new ArrayList<>();
    private List<Car> warehouse = new ArrayList<>();


    private Boolean exactCarInWarehouse;
    private CarService carService;

    public Factory(Brand[] brands, Engine[] engines, Color[] colors, Wheels[] wheels, Options... options) {
        if (brands != null) {
            for (Brand brand : brands) {
                this.brands.add(brand);
            }
        }
        if (engines != null) {
            for (Engine engine : engines) {
                this.engines.add(engine);
            }
        }
        if (colors != null) {
            for (Color color : colors) {
                this.colors.add(color);
            }
        }
        if (wheels != null) {
            for (Wheels wheel : wheels) {
                this.wheels.add(wheel);
            }
        }
        if (options != null) {
            for (Options options1 : options) {
                this.options.add(options1);
            }
        }

        for (Brand brand : brands) {
            for (Engine engine : engines) {
                for (Color color : colors) {
                    warehouse.add(createCar(brand, engine, color, this.wheels.get(0), this.options));
                }
            }
        }

    }

    public Car orderCar(Brand brand, Engine engine, Color color, Wheels wheels, List<Options> options) {
        Car orderCar = null;
        if (orderValidation(brand, engine, color, wheels, options)) {
            orderCar = findCarInWarehouse(brand, engine, color, wheels, options);
            if (orderCar != null) {
                warehouse.remove(orderCar);
                if (!exactCarInWarehouse) {
                    serviceCar(orderCar, color, wheels, options);
                }
                return orderCar;
            } else {
                return createCar(brand, engine, color, wheels, options);
            }
        }
        return null;

    }

    private Car findCarInWarehouse(Brand brand, Engine engine, Color color, Wheels wheels, List<Options> options) {
        Car carInWarehouse = null;
        int previousMatches = 0;
        exactCarInWarehouse = false;

        for (Car car : warehouse) {
            int currentMatches = 0;
            if (car.getBrand().equals(brand) && car.getEngine().equals(engine)) {
                currentMatches++;
                if (car.getColor().equals(color)) {
                    currentMatches++;
                    if (car.getOptions().size() == options.size() && car.getOptions().containsAll(options)) {
                        currentMatches++;
                        if (car.getWheels().equals(wheels)) {
                            exactCarInWarehouse = true;
                            return car;
                        }
                    }
                }
            }
            if (currentMatches > previousMatches) {
                previousMatches = currentMatches;
                carInWarehouse = car;
            }
        }
        return carInWarehouse;
    }

    private Boolean orderValidation(Brand brand, Engine engine, Color color, Wheels wheels, List<Options> options) {
        if (brands.contains(brand) && engines.contains(engine) && colors.contains(color) && this.wheels.contains(wheels) && this.options.containsAll(options)) {
            return true;
        } else {
            return false;
        }
    }

    private void serviceCar(Car car, Color color, Wheels wheels, List<Options> options) {
        carService.changeColor(car, color);
        carService.changeWheels(car, wheels);

        for (Options option : options) {
            if (!car.getOptions().contains(option)) {
                carService.addOption(car, option);
            }
        }
        Iterator<Options> optionsIterator = car.getOptions().iterator();
        while (optionsIterator.hasNext()) {
            Options options1 = optionsIterator.next();
            System.out.println(options1);
            if (!options.contains(options1)) {
                carService.removeOption(car, options1);
            }
        }
    }


    private Car createCar(Brand brand, Engine engine, Color color, Wheels wheelsSize, List<Options> options) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return new Car(brand, engine, year, color, wheelsSize, options);
    }

    public String getBrands() {
        return "Factory brands " + brands;
    }

    public String getEngines() {
        return "Factory engines " + engines;
    }

    public String getColors() {
        return "Factory colors  " + colors;
    }

    public String getWheels() {
        return "Factory wheels  " + wheels;
    }

    public String getOptions() {
        return "Factory options  " + options;
    }

    public List<Car> getWarehouse() {
        return warehouse;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
