package com.github.ji4597056.practice.Practice27;

/**
 * 27. Remove Element
 *
 * @author Jeffrey
 * @since 2018/02/06 13:50
 */
public class Practice27 {

    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            nums[i] = nums[j];
            if (nums[i] != val) {
                i++;
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        nums = new int[]{3};
        System.out.println(removeElement(nums, 3));
    }
}
