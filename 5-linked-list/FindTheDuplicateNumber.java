/**
 * https://neetcode.io/problems/find-duplicate-integer/question?list=neetcode150
 * 
 * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
 * There is exactly one repeated integer in nums, and every other integer appears at most once.
 * Return the repeated integer.
 * 
 * Follow-up: Can you solve the problem without modifying the array nums and using 
 * O(1)O(1) extra space?
 * 
 * Constraints:
 * 1 <= n <= 10,000
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int sp = nums[0];
        int fp = nums[0];

        do {
            sp = nums[sp];
            fp = nums[fp];
            fp = nums[fp];
        } while (sp != fp);

        sp = nums[0];
        while (sp != fp) {
            sp = nums[sp];
            fp = nums[fp];
        }

        return sp;
    }
}
