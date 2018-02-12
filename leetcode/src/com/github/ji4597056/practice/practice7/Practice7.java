package com.github.ji4597056.practice.practice7;

/**
 * 7. Reverse Integer
 *
 * @author Jeffrey
 * @since 2017/12/19 12:32
 */
public class Practice7 {

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int i = x % 10;
            x = x / 10;
            result = result * 10 + i;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

    public static int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            // 灵活的判断溢出
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i * 10);
    }
}
