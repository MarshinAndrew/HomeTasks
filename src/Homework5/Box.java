package Homework5;

import java.io.Serializable;

public class Box implements Serializable, Comparable<Box> {

    private final int lengths;
    private final int width;
    private final int height;

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


    public int getLengths() {
        return lengths;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getVolume() {
        return lengths * width * height;
    }

    @Override
    public int compareTo(Box anotherBox) {

        if (getVolume() == anotherBox.getVolume()) {
            return 0;
        } else if (getVolume() > anotherBox.getVolume()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return "Box{" + "lengths=" + lengths + ", width=" + width + ", height=" + height + ", volume=" + getVolume() +'}';
    }
}
