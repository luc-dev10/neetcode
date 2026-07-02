/**
 * 
 * https://neetcode.io/problems/find-target-in-rotated-sorted-array/question?list=neetcode150
 * 
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 * You may assume all elements in the sorted rotated array nums are unique,
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -1000 <= target <= 1000
 * All values of nums are unique
 * nums is an ascending array that is possibly rotated.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }

        return - 1;
    }
}