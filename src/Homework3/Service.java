package Homework3;

public class Service implements CarService {

    @Override
    public void changeColor(Car car, Color color) {
        if (!car.getColor().equals(color)) {
            car.setColor(color);
        }
    }

    @Override
    public void changeWheels(Car car, Wheels wheels) {
        if (!car.getWheels().equals(wheels)) {
            car.setWheels(wheels);
        }
    }

    @Override
    public void addOption(Car car, Options... options) {
        if (options != null) {
            for (Options option : options) {
                car.getOptions().add(option);
            }
        }
    }

    @Override
    public void removeOption(Car car, Options... options) {
        if (options != null) {
            for (Options option : options) {
                car.getOptions().remove(option);
            }
        }
    }
}
