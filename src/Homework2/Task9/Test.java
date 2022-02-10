package Homework2.Task9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String testString = "Select your browser's print icon, or select print from the menu, to print just an article and its word guide. ";
        String testWord = "   Browser's  ";

        Pattern testWordPattern = Pattern.compile("[^а-яА-Я\\w]*(([\\wа-яА-я]+['-]*[\\wа-яА-я]+)|[\\wа-яА-Я]+)[^а-яА-Я\\w]*");
        Matcher testWordMatcher = testWordPattern.matcher(testWord);

        if (testWordMatcher.matches()) {
            Pattern testStringPattern = Pattern.compile("\\b" + testWordMatcher.group(2) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher testStringMatcher = testStringPattern.matcher(testString);
            if (testStringMatcher.find()) {
                System.out.println(testStringMatcher.group());
                System.out.println(testStringMatcher.start());
            } else {
                System.out.println("No matches");
            }
        } else {
            System.out.println("Program can't work with such words");
        }


    }
}
