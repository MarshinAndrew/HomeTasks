package Homework2.Task10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Box {

    private final int lengths;
    private final int width;
    private final int height;

    public Box(String boxParameters) {

        if (Pattern.matches("Box\\[(\\d+,){0,2}\\d+\\]", boxParameters)) {
            Pattern boxValuesPattern = Pattern.compile("\\d+");
            Matcher boxValuesMatcher = boxValuesPattern.matcher(boxParameters);
            int[] boxValuesArray = new int[3];
            int index = 0;
            while (boxValuesMatcher.find()) {
                boxValuesArray[index] = Integer.parseInt(boxValuesMatcher.group());
                index++;
            }
            switch (index) {
                case 1:
                    this.lengths = boxValuesArray[0];
                    this.width = boxValuesArray[0];
                    this.height = boxValuesArray[0];
                    break;
                default:
                    this.lengths = boxValuesArray[0];
                    this.width = boxValuesArray[1];
                    this.height = boxValuesArray[2];
                    break;
            }
        } else {
            this.lengths = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    public Box(int size) {
        this(size, size, size);
    }

    public Box(int lengths, int width) {
        this(lengths, width, 0);
    }

    public Box(int lengths, int width, int height) {
        this.lengths = lengths;
        this.width = width;
        this.height = height;
    }

    public String boxType() {
        if (lengths == width && lengths == height) {
            return "Cubic box";
        } else if (height == 0) {
            return "Envelope";
        }
        return "Regular box";
    }

    public int getLengths() {
        return lengths;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
