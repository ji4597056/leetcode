package com.github.ji4597056.practice.practice38;

/**
 * 38. Count and Say
 *
 * @author Jeffrey
 * @since 2018/02/11 0:49
 */
public class Practice38 {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder("");
        int k = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ch) {
                result.append(k).append(String.valueOf(ch));
                k = 1;
                ch = c;
            } else {
                k++;
            }
        }
        result.append(k).append(String.valueOf(ch));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
