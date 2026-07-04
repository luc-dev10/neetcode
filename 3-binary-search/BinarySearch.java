/**
 * 
 * https://neetcode.io/problems/binary-search/question?list=neetcode150
 * 
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 * Your solution must run in O(logn) time.
 * 
 * Constraints:
 * 1 <= nums.length <= 10000.
 * -10000 < nums[i], target < 10000
 * All the integers in nums are unique.
 * 
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = ((r - l) / 2) + l;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}