package Homework2.Task4;


public enum CarColors {

    AUDI("Audi", new String[]{"blue", "red", "green"}),
    BMW("BMW", new String[]{"orange", "black", "violet"}),
    KIA("KIA", new String[]{"yellow", "grey", "white"});

    private final String brand;
    private final String[] colors;

    CarColors(String name, String[] colors) {
        this.brand = name;
        this.colors = colors;
    }

    public static String[] getColors(String carBrand) {
        for (CarColors car : values()) {
            if (car.brand.toLowerCase().equals(carBrand.toLowerCase())) {
                return car.colors;
            }
        }
        return new String[]{""};
    }
}
