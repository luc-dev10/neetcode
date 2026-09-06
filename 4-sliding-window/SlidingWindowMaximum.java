/**
 * 
 * https://neetcode.io/problems/sliding-window-maximum/question?list=neetcode150
 * 
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
 * Return a list that contains the maximum element in the window at each step.
 * 
 * Constraints:
 * 1 <= nums.length <= 100,000
 * -10,000 <= nums[i] <= 10,000
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[r]) {
                dq.removeLast();
            }

            dq.addLast(r);

            if (r - l + 1 == k) {
                res[l] = nums[dq.getFirst()];
                if (dq.getFirst() == l) dq.removeFirst();
                l++;
            }
        }
        
        return res;    
    }
}

}
