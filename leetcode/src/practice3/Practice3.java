package practice3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 3.Longest Substring Without Repeating Characters
 *
 * @author Jeffrey
 * @since 2017/12/11 17:25
 */
public class Practice3 {

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        List<Character> characters = new ArrayList<>((int) (s.length() / 0.75 + 1));
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int position = characters.indexOf(character);
            if (position == -1) {
                characters.add(character);
                length = Math.max(length, characters.size());
            } else {
                for (int j = 0; j <= position; j++) {
                    characters.remove(0);
                }
                characters.add(character);
            }
        }
        return length;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口优化
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 滑动窗口需要双指针
        Practice3 practice3 = new Practice3();
        System.out.println(practice3.lengthOfLongestSubstring2("abcabcbb"));
    }
}
