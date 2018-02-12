package com.github.ji4597056.practice.practice29;

/**
 * 29. Divide Two Integers
 *
 * @author Jeffrey
 * @since 2018/02/06 16:52
 */
public class Practice29 {

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int newDivisor = divisor;
        int result = 0;
        while ((newDivisor << 2) <= dividend) {
            result += 2;
        }
        if (divisor == dividend ){
            return result;
        }
        while ((newDivisor-divisor) > dividend){
            result -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(4,2));
        System.out.println(divide(5,2));
        System.out.println(divide(6,2));
        System.out.println(divide(7,2));
        System.out.println(divide(8,2));
        System.out.println(divide(8,3));
    }
}
