package com.github.ji4597056.practice.practice15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 15. 3Sum
 *
 * @author Jeffrey
 * @since 2018/01/04 9:52
 */
public class Practice15 {

    public List<List<Integer>> threeSum1(int[] A) {
        List<List<Integer>>res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i - 1 >= 0 && A[i] == A[i - 1]) {
                continue;// Skip equal elements to avoid duplicates
            }

            int left = i + 1, right = A.length - 1;
            while (left < right) {// Two Pointers
                int sum = A[i] + A[left] + A[right];
                if (sum == 0) {
                    res.add(Arrays.asList(A[i], A[left], A[right]));
                    while (left + 1 < right && A[left] == A[left+1])// Skip equal elements to avoid duplicates
                    {
                        left++;
                    }
                    while (right -1 > left && A[right] == A[right-1])// Skip equal elements to avoid duplicates
                    {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /*=======================================================*/

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> total = new HashMap<>();
        List<Integer> newNums = new ArrayList<>();
        Arrays.stream(nums).forEach(value -> {
            Integer number = total.get(value);
            total.put(value, number == null ? 1 : number + 1);
            if (number == null || number <= 2){
                newNums.add(value);
            }
        });
        Map<Num, Integer> numMap = new HashMap<>();
        for (int i = 0; i < newNums.size(); i++) {
            if (nums[i] <= 0) {
                for (int j = 0; j < newNums.size(); j++) {
                    if (i != j) {
                        int num = -nums[i] - nums[j];
                        if (nums[j] >= nums[i] && num >= nums[j]) {
                            Integer number = total.get(num);
                            if (number != null) {
                                if (num != nums[j] && number >= 1) {
                                    numMap.put(new Num(nums[i], nums[j]), num);
                                } else if (num == nums[j] && num != nums[i] && number >= 2) {
                                    numMap.put(new Num(nums[i], nums[j]), num);
                                } else if (num == nums[j] && num == nums[i] && number >= 3) {
                                    numMap.put(new Num(nums[i], nums[j]), num);
                                }
                            }
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        numMap.forEach(
            (num, integer) -> result.add(Arrays.asList(num.getN1(), num.getN2(), integer)));
        return result;
    }

    public static class Num {

        private final Integer n1;

        private final Integer n2;

        public Num(Integer n1, Integer n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public Integer getN1() {
            return n1;
        }

        public Integer getN2() {
            return n2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Num num = (Num) o;

            if (n1 != null ? !n1.equals(num.n1) : num.n1 != null) {
                return false;
            }
            return n2 != null ? n2.equals(num.n2) : num.n2 == null;
        }

        @Override
        public int hashCode() {
            int result = n1 != null ? n1.hashCode() : 0;
            result = 31 * result + (n2 != null ? n2.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1};
        System.out.println(threeSum(nums));
    }
}
