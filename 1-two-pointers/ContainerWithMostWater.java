
/**
 * 
 * https://neetcode.io/problems/max-water-container/question?list=neetcode150
 * 
 * You are given an integer array heights where heights[i] represents the height of the ith bar.
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 * 
 * Constraints:
 * 2 <= height.length <= 1000
 * 0 <= height[i] <= 1000
 */
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int m = 0;

        while (l < r) {
            int w = r - l;
            int h = Math.min(heights[l], heights[r]);
            m = Math.max(w * h, m);
            if (heights[l] < heights[r]) l++;
            else r--; 
        }

        return m;
    }
}