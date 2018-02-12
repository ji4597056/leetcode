package com.github.ji4597056.practice.practice22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author Jeffrey
 * @since 2018/02/02 10:10
 */
public class Practice22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    // 666,递归思想
    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if(close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        new Practice22().generateParenthesis(2).forEach(System.out::println);
    }
}
