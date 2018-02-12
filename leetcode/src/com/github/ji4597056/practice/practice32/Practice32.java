package com.github.ji4597056.practice.practice32;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * @author Jeffrey
 * @since 2018/02/07 11:04
 */
public class Practice32 {

    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int tmp = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (stack.peek() == '(' && ch == ')') {
                stack.pop();
                tmp += 2;
            } else if (stack.peek() != '(' && ch == ')') {
                stack.push(ch);
                tmp = 0;
            } else {
                stack.push(ch);
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    // 厉害
    public static int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, right + left);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                maxLength = Math.max(maxLength, right + left);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "())((())";
        System.out.println(longestValidParentheses2(s));
        s = "(()";
        System.out.println(longestValidParentheses2(s));
    }
}
