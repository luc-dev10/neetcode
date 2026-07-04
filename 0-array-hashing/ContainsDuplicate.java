/**
 * https://neetcode.io/problems/duplicate-integer/
 * 
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 * 
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums) {
            if (s.contains(n)) return true;
            s.add(n);
        }

        return false;
    }
}