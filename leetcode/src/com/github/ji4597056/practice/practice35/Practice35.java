package com.github.ji4597056.practice.practice35;

/**
 * 35. Search Insert Position
 *
 * @author Jeffrey
 * @since 2018/02/09 10:02
 */
public class Practice35 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 5));
        nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }
}
