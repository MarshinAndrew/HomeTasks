package Homework2.Task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String testString = " Когда-нибудь я научусь этим REGEX!!!";
        String longestWord = new String();

        Pattern longestWordPattern = Pattern.compile("\\b([\\wа-яА-Я]+['-]*[\\wа-яА-Я]+)|[\\wа-яА-Я]+\\b");
        Matcher longestWordMatcher = longestWordPattern.matcher(testString);

        while (longestWordMatcher.find()) {
            longestWord = (longestWordMatcher.group().length() > longestWord.length()) ? longestWordMatcher.group() : longestWord;
        }
        System.out.println("Longest word is "+longestWord);
    }
}
