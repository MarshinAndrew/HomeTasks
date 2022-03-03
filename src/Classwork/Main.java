package Classwork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList= new ArrayList<>();
        LinkedList<String> linkedList=new LinkedList<>();

        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);


        linkedList.add("Hello");
        linkedList.add("Hello1");
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        Set<Integer> list=new HashSet<>();
        Set<Integer> list1=new LinkedHashSet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(null);
        System.out.println(list);
        System.out.println(list.size());
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        list1.add(null);
        System.out.println(list1);
        System.out.println(list1.size());



    }
}
