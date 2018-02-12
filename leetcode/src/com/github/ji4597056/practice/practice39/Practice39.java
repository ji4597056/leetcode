package com.github.ji4597056.practice.practice39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 39. Combination Sum
 *
 * @author Jeffrey
 * @since 2018/02/11 9:58
 */
public class Practice39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            combinationSum(candidates, i, target, new ArrayList<>(), result);
        }
        return result;
    }

    private static void combinationSum(int[] candidates, int idx, int target, List<Integer> list,
        List<List<Integer>> lists) {
        if (idx >= candidates.length || target < 0) {
            return;
        } else if (target == 0) {
            lists.add(list);
            return;
        }
        int k = candidates[idx];
        List<Integer> l1 = new ArrayList<>(list);
        l1.add(k);
        combinationSum(candidates, idx, target - k, l1, lists);
        if (!list.isEmpty()) {
            for (int j = idx + 1; j < candidates.length; j++) {
                List<Integer> l2 = new ArrayList<>(list);
                k = candidates[j];
                l2.add(k);
                combinationSum(candidates, j, target - k, l2, lists);
            }
        }
    }

    // 性能优化
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void combinationSum(List<List<Integer>> result, List<Integer> cur,
        int[] candidates,
        int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length;
                i++) { // not using the condition "target >= candidates[i]"
                cur.add(candidates[i]);
                combinationSum(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum1(IntStream.of(2, 3, 6, 7).toArray(), 7);
        System.out.println(lists.size());
    }
}
