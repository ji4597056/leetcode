package com.github.ji4597056.practice.practice5;

import java.util.Objects;

/**
 * 5. Longest Palindromic Substring
 *
 * @author Jeffrey
 * @since 2017/12/15 9:47
 */
public class Practice5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() > 1000) {
            throw new IllegalArgumentException("s is null or s length is greater than 1000");
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && (result == null || (j - i + 1) > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (end > start) {
            if (!Objects.equals(s.charAt(start++), s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }

    /*
       扩张
     */
    public static String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome1(s));
    }
}
