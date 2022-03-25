package Homework2.Task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String testString = " Asa-a,  a, asa, afafa, asasddoiahf, tiuh    ";

        Pattern wordPattern = Pattern.compile("\\b((a\\w*['-]*\\w*a)|a)\\b", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordPattern.matcher(testString);

        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }
    }
}
