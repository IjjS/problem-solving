package leetcode.string.Q937;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        String[] input = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(reorderLogFiles(input)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Collections.sort(Arrays.asList(logs), stringComparator);
        return logs;
    }

    static Comparator<String> stringComparator = (s1, s2) -> {
        String[] firstLog = s1.split(" ", 2);
        String[] secondLog = s2.split(" ", 2);
        boolean isFirstLetter = Character.isLetter(firstLog[1].charAt(0));
        boolean isSecondLetter = Character.isLetter(secondLog[1].charAt(0));

        if (isFirstLetter && !isSecondLetter)
            return -1;
        if (!isFirstLetter && isSecondLetter)
            return 1;
        if (!isFirstLetter)
            return 0;

        int cntCmp = firstLog[1].compareTo(secondLog[1]);

        if (cntCmp == 0) {
            return firstLog[0].compareTo(secondLog[0]);
        }

        return cntCmp;
    };
}
