package Homework2.Task10;

public class Test {
    public static void main(String[] args) {

        Box box1 = new Box("Box[122,222,333]");

        System.out.println(box1.getLengths());
        System.out.println(box1.getWidth());
        System.out.println(box1.getHeight());
        System.out.println();

        Box box2 = new Box("Box[122]");

        System.out.println(box2.getLengths());
        System.out.println(box2.getWidth());
        System.out.println(box2.getHeight());
        System.out.println();

        Box box3 = new Box("Box[122,222]");

        System.out.println(box3.getLengths());
        System.out.println(box3.getWidth());
        System.out.println(box3.getHeight());
        System.out.println();

        Box box4 = new Box("Box5[122,124,125]");

        System.out.println(box4.getLengths());
        System.out.println(box4.getWidth());
        System.out.println(box4.getHeight());
    }
}
