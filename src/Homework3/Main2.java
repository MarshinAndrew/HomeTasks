package Homework3;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<Object, Object> map1= new HashMap<>();
        map1.put("qw","123");
        map1.put(1,3);


        System.out.println(map1.get("qw"));


    }
}
