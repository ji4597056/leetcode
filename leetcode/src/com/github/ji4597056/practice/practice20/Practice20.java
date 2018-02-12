package com.github.ji4597056.practice.practice20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * @author Jeffrey
 * @since 2018/02/01 9:55
 */
public class Practice20 {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(5);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.isEmpty() || !Objects.equals(list.peek(), map.get(s.charAt(i)))) {
                list.push(s.charAt(i));
            } else {
                list.poll();
            }
        }
        return list.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
