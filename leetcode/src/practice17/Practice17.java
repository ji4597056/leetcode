package practice17;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * @author Jeffrey
 * @since 2018/01/09 14:18
 */
public class Practice17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String> left = map.get(digits.charAt(0));
        for (int i = 1; i < digits.length(); i++) {
            List<String> right = map.get(digits.charAt(i));
            left = left.stream().flatMap(l -> right.stream().map(r -> l + r))
                .collect(Collectors.toList());
        }
        return left;
    }

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        // 链表集合
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Practice17 practice = new Practice17();
        String digits = "34567";
        System.out.println(practice.letterCombinations1(digits));
    }
}
