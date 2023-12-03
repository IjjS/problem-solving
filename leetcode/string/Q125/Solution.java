package leetcode.string.Q125;

import java.util.Scanner;

public class Solution {
    public static boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return true;
        }

        String regex = "[^a-z0-9]";
        s = s.toLowerCase()
                .replaceAll(regex, "");
        int end = s.length();

        for (int i = 0; i < end / 2; i++) {
            if (s.charAt(i) != s.charAt(end - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
