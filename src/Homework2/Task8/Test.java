package Homework2.Task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String testString = "rr+1587-99999-9999-9999-9999-9999-r-9999-9999-9999-9999rr989898-977755-99955-9-99999-888554-";

        Pattern numbersPattern = Pattern.compile("(?<!\\d-|\\d)((\\d{4}-){3}\\d{4})(?!-\\d|\\d)");
        Matcher numbersMatcher = numbersPattern.matcher(testString);

        while (numbersMatcher.find()) {
            System.out.println(numbersMatcher.group());
        }


    }
}
