/*
 * https://neetcode.io/problems/two-integer-sum/question?list=neetcode150
 *
 * Given an array of integers nums and an integer 
 * target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 * 
 * Return the answer with the smaller index first.
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 * Only one valid answer exists.
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (hm.containsKey(v)) return new int[] {hm.get(v),i};
            hm.put(target - v, i);
        }

        return null;
    }
}