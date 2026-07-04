/**
 * 
 * https://neetcode.io/problems/largest-rectangle-in-histogram/question?list=neetcode150
 * 
 * You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
 * Return the area of the largest rectangle that can be formed among the bars.
 * Note: This chart is known as a histogram.
 * 
 * Constraints:
 * 1 <= heights.length <= 1000.
 * 0 <= heights[i] <= 1000
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> dq = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = i;

            while(!dq.isEmpty() && dq.getLast()[0] > h) {
                int[] t = dq.removeLast();
                max = Math.max((i - t[1]) * t[0], max);
                w = t[1];
            }

            dq.addLast(new int[] {h, w});
        }

        while (!dq.isEmpty()) {
            int[] t = dq.removeLast();
            max = Math.max((heights.length - t[1]) * t[0], max);
        }

        return max;
    }
}
