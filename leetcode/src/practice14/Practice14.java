package practice14;

/**
 * 14. Longest Common Prefix
 *
 * @author Jeffrey
 * @since 2018/01/03 11:06
 */
public class Practice14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != first.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    /*=================================================*/

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String lstr = longestCommonPrefix(strs, left, mid);
        String rstr = longestCommonPrefix(strs, mid, right);
        return commonPrefix(lstr, rstr);
    }

    private String commonPrefix(String lstr, String rstr) {
        int min = Math.min(lstr.length(), rstr.length());
        if (min == 0) {
            return "";
        }
        for (int i = 0; i < min; i++){
            if (lstr.charAt(i) != rstr.charAt(i)){
                return lstr.substring(0, i);
            }
        }
        return lstr.substring(0, min);
    }
}
