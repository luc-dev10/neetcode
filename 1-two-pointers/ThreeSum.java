/**
 * 
 * https://neetcode.io/problems/three-integer-sum/question?list=neetcode150
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 * 
 * Constraints:
 * 3 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 * 
 */
public class TreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int t = nums[l] + nums[r] + nums[i];
                if (t == 0) {
                    res.add(List.of(nums[i], nums[l++], nums[r--]));
                    while (l < nums.length && nums[l - 1] == nums[l]) l++;
                } else if (t < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}