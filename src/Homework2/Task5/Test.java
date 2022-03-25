package Homework2.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String testString = "Ccc acaaaaaaaacaca ccacca cc aaa cccccccccc acacac cc1ac frog  ";

        Pattern wordPattern = Pattern.compile("\\b(\\w*c\\w*){3}\\b", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordPattern.matcher(testString);

        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }
    }
}


