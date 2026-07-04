/**
 * https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode150
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * The test cases are generated such that the answer is always unique.
 * You may return the output in any order.
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4.
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= number of distinct elements in nums.
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] f = new ArrayList[nums.length + 1];

        for (int n : nums) hm.put(n, hm.getOrDefault(n ,0) + 1);
        
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (f[e.getValue()] == null) f[e.getValue()] = new ArrayList<>();
            f[e.getValue()].add(e.getKey());
        }
        
        int[] res = new int[k];
        int t = 0;
        for (int i = f.length - 1; i >= 0 && t < k; i--) {
            List<Integer> l = f[i];
            if (l == null) continue;

            for (int j = 0; j < l.size() && t < k; j++) {
                res[t++] = l.get(j);
           }
        }

        return res;
    }
}