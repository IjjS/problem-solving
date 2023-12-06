package leetcode.string.q125;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        sc.close();

        boolean palindrome = isPalindrome(s);

        System.out.println(palindrome);
    }

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
