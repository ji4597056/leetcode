package com.github.ji4597056.practice.practice26;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * @author Jeffrey
 * @since 2018/02/06 13:07
 */
public class Practice26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        int i = 1, j = 1;
        for (; i < nums.length && j < nums.length; ) {
            if (nums[i] == nums[i - 1]) {
                if (j == nums.length - 1) {
                    break;
                }
                nums[i] = nums[++j];
            } else {
                i++;
            }
        }
        nums = Arrays.copyOf(nums, i);
        return i;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates1(nums));
        nums = new int[]{1, 2};
        System.out.println(removeDuplicates1(nums));
    }
}
