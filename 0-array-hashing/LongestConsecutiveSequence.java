/**
 * https://neetcode.io/problems/longest-consecutive-sequence/question?list=neetcode150
 * 
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
 * You must write an algorithm that runs in O(n) time.
 *
 * Constraints:
 * 0 <= nums.length <= 1000
 * -10^9 <= nums[i] <= 10^9
 * 
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        int max = nums.length > 0 ? 1 : 0;

        for (int num : nums) {
            if (s.contains(num - 1)) continue;
            int n = num + 1;
            int t = 1;
            while (s.contains(n)) {
                max = Math.max(++t, max);
                n++;
            }
        }

        return max;
    }
}