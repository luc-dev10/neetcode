/**
 * 
 * https://neetcode.io/problems/daily-temperatures/question?list=neetcode150
 * 
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 * 
 * Constraints:
 * 1 <= temperatures.length <= 1000.
 * 1 <= temperatures[i] <= 100
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!dq.isEmpty() && dq.getLast()[0] < temperatures[i]) {
                int[] p = dq.removeLast();
                res[p[1]] = i - p[1];
            }

            dq.addLast(new int[] {temperatures[i],i});
        }

        return res;
    }
}
