package practice1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.Two Sum
 *
 * @author Jeffrey
 * @since 2017/11/18 22:11
 */
public class Practice1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // 精髓(少一次for循环和判断)
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
