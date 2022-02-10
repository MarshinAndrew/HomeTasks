package Homework2.Task1;

public enum Month {
    JANUARY("January", 1),
    FEBRUARY("February", 2),
    MARCH("March", 3),
    APRIL("April", 4),
    MAY("May", 5),
    JUNE("June", 6),
    JULY("July", 7),
    AUGUST("August", 8),
    SEPTEMBER("September", 9),
    OCTOBER("October", 10),
    NOVEMBER("November", 11),
    DECEMBER("December", 12);

    private final String name;
    private final int number;

    Month(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static String getMonthNameByNumber(int number) {
        for (Month month : values()) {
            if (month.number == number) {
                return month.name;
            }
        }
        return null;
    }

    public static int getMonthNumberByName(String name) {
        for (Month month : values()) {
            if (month.name.toLowerCase().equals(name.toLowerCase())) {
                return month.number;
            }
        }
        return -1;
    }
}
