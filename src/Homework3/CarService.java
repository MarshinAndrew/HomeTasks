package Homework3;

public interface CarService {
    public void changeColor(Car car,Color color);
    public void changeWheels(Car car,Wheels wheels);
    public void addOption(Car car,Options ...option);
    public void removeOption(Car car,Options ...option);

}
