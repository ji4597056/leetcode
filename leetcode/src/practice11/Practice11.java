package practice11;

/**
 * 11. Container With Most Water
 *
 * @author Jeffrey
 * @since 2017/12/22 16:56
 */
public class Practice11 {

    /*
        经典
     */
    public static int maxArea1(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxarea = Math.max(Math.min(height[left], height[right]) * (right - left), maxarea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    public static int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    /**
     * error 理解错误
     */
    public static int XmaxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException();
        }
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            while ((left >= 0 && height[left] <= height[i])
                || right < length && height[right] <= height[i]) {
                if (left >= 0 && height[left] >= height[i]) {
                    left--;
                }
                if (right < length && height[right] >= height[i]) {
                    right++;
                }
            }
            max = Math.max((right - left - 2) * height[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(XmaxArea(new int[]{1, 2}));
    }

}
