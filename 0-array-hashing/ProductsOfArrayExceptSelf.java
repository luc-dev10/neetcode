/**
 * 
 * https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150
 * 
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
 * Each product is guaranteed to fit in a 32-bit integer.
 * Follow-up: Could you solve it in O(n) & O(n) time without using the division operation?
 * 
 * Constraints:
 * 2 <= nums.length <= 1000
 * -20 <= nums[i] <= 20
 * 
*/
public class ProductsOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // prefix
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // postfix
        int[] p = new int[nums.length];
        p[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            p[i] = p[i + 1] * nums[i + 1];
        }

        // result
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * p[i];
        }

        return res;
    }
}  
