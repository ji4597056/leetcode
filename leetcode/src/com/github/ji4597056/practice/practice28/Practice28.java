package com.github.ji4597056.practice.practice28;

import java.util.Objects;

/**
 * 28. Implement strStr()
 *
 * @author Jeffrey
 * @since 2018/02/06 14:30
 */
public class Practice28 {

    public int strStr(String haystack, String needle) {
        if (Objects.equals(haystack, needle)) {
            return 0;
        }
        int len = haystack.length() - needle.length();
        for (int i = 0; i < len + 1; i++) {
            if (Objects.equals(haystack.substring(i, i + needle.length()), needle)) {
                return i;
            }
        }
        return -1;
    }
}
