package practice4;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 *
 * @author Jeffrey
 * @since 2017/12/14 9:51
 */
public class Practice4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(nums);
        int n = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (nums[n] + nums[n - 1]) / 2.0;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
