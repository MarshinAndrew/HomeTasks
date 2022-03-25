package Homework2.Task4;

public class Car {

    private final String brand;
    private String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void changeColor(String newColor) {
        for (String color : CarColors.getColors(brand)) {
            if (color.toLowerCase().equals(newColor.toLowerCase())) {
                this.color = newColor;
            }
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
