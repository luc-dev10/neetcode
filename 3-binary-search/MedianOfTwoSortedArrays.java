/**
 * 
 * https://neetcode.io/problems/median-of-two-sorted-arrays/question
 * 
 * You are given two integer arrays nums1 and nums2 of size m and n respectively, where each is sorted in ascending order. Return the median value among all elements of the two arrays.
 * Your solution must run in O(log(m+n)) O(log(m+n)) time.
 * 
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */
public class MedianOfTwoSortedArrays {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // size and left partition size
        int s = nums1.length + nums2.length;
        int ps = (s + 1) / 2;

        // log(min(n,m)) trick
        int[] sa = nums1.length <= nums2.length ? nums1 : nums2;
        int[] ba = nums1.length <= nums2.length ? nums2 : nums1;
        int l = 0;
        int r = sa.length;

        while (l <= r) {
            // create partition lines for both arrays
            int lp = (r - l) / 2 + l;
            int rp = ps - lp;

            // identify adjancent/boundary elements in partition line - handle edge cases
            int sl = lp > 0 ? sa[lp - 1] : Integer.MIN_VALUE;
            int sr = lp < sa.length ? sa[lp] : Integer.MAX_VALUE;
            int bl = rp > 0 ? ba[rp - 1] : Integer.MIN_VALUE;
            int br = rp < ba.length ? ba[rp] : Integer.MAX_VALUE;
            
            // [left = sl & bl | right = sr & br]
            // all elements in the left partition must be <= to all elements in the right partition.
            // since arrays are sorted, we can check this condition from adjancent/boundary elements.
            if (sl <= br && bl <= sr) {
                // The partition boundaries can come from either array.
                // The largest value on the left side is max(sl, bl).
                // The smallest value on the right side is min(sr, br).
                // These two boundary values determine the median.

                // Odd: median is the middle value.
                // Even: median is the average of the two middle values.
                return s % 2 == 1 ? Math.max(sl, bl) : (Math.max(sl, bl) + Math.min(sr, br)) / 2.0;
            }

            // refine cut in partition through bs
            if (sl > br) r = lp - 1;
            else l = lp + 1;
        }

        return -1;
    }
}
