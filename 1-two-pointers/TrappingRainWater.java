/**
 * 
 * https://neetcode.io/problems/trapping-rain-water/question?list=neetcode150
 * 
 * You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
 * Return the maximum area of water that can be trapped between the bars.
 *
 * Constraints:
 * 1 <= height.length <= 1000
 * 0 <= height[i] <= 1000
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int r = height.length - 1;
        int l = 0, ml = 0, mr = 0, t = 0;

        while (l < r) {
            ml = Math.max(ml, height[l]);
            mr = Math.max(mr, height[r]);
            if (height[l] < height[r]) t += ml - height[l++];
            else t += mr - height[r--];
        }
        return t;
    }
}