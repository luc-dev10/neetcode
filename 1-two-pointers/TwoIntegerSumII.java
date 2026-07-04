/**
 * 
 * https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150
 * 
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 * There will always be exactly one valid solution.
 * Your solution must use O(1) O(1) additional space.
 * 
 * Constraints:
 * 2 <= numbers.length <= 1000
 * -1000 <= numbers[i] <= 1000
 * -1000 <= target <= 1000
 */
public class TwoIntegerSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int t = numbers[l] + numbers[r];
            if (t == target) return new int[] {l+1, r+1};
            if (t < target) l++;
            else r--;
        }

        return null;
    }
}