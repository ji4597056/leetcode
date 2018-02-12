package com.github.ji4597056.practice.practice9;

/**
 * 9. Palindrome Number
 *
 * @author Jeffrey
 * @since 2017/12/20 15:58
 */
public class Practice9 {

    public static boolean isPalindrome1(int x) {
        // 先过滤
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        // 折中判断
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static boolean isPalindrome(int x) {
        int origin = x;
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10;
            reverse += x % 10;
            x = x / 10;
        }
        return reverse == origin;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(1234321));
    }
}
