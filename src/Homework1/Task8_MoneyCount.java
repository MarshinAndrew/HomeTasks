package Homework1;

import java.util.Arrays;

public class Task8_MoneyCount {

    public static void main(String[] args) {

        int[] i = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};

        int[] i1 = {5,0,0};

        int[] i2={5,0,1,2,7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(i2));

        System.out.println(ArrayOperations.moneyCount(i2));

    }


}
