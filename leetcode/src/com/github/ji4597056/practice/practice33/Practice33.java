package com.github.ji4597056.practice.practice33;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author Jeffrey
 * @since 2018/02/08 9:54
 */
public class Practice33 {

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (target < nums[0]) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
}
