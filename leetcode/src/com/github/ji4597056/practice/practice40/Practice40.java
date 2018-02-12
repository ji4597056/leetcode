package com.github.ji4597056.practice.practice40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 40. Combination Sum II
 *
 * @author Jeffrey
 * @since 2018/02/11 13:03
 */
public class Practice40 {

    public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (i == 0 || (i > 0 && candidates[i] != candidates[i - 1])) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i, list, lists);
            }
        }
        return lists;
    }

    public static void combinationSum2(int[] candidates, int target, int start, List<Integer> list,
        List<List<Integer>> lists) {
        if (target > 0) {
            for (int i = start + 1;
                !list.isEmpty() && i < candidates.length && target >= candidates[i]; i++) {
                list.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i, list, lists);
                list.remove(list.size() - 1);
            }
        } else if (target == 0) {
            lists.add(new ArrayList<>(list));
        }
    }

    // 性能优化
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void combinationSum2(List<List<Integer>> result, List<Integer> cur,
        int[] candidates,
        int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                combinationSum2(result, cur, candidates, target - candidates[i], i + 1);
                int rm = cur.get(cur.size() - 1);
                cur.remove(cur.size() - 1);
                while (i < candidates.length - 1 && rm == candidates[i + 1]) {
                    i++;
                }
            }
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(IntStream.of(10, 1, 2, 7, 6, 1, 5).toArray(),
            8);
        System.out.println(lists.size());
    }
}
