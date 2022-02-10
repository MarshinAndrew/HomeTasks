package Homework2.Task2;

public class Box {

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
