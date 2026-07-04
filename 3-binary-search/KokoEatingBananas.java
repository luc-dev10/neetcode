/**
 * https://neetcode.io/problems/eating-bananas/question?list=neetcode150
 * 
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.
 * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
 * Return the minimum integer k such that you can eat all the bananas within h hours.
 * 
 * Constraints:
 * 1 <= piles.length <= 1,000
 * piles.length <= h <= 1,000,000
 * 1 <= piles[i] <= 1,000,000,000
 * 
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p : piles) if (p > r) r = p;
        int k = r;

        while (l <= r) {
            int m = (r - l) / 2 + l;
            int time = 0;
            for (int p : piles) {
                time += p / m;
                if (p % m != 0) time++;
            }

            if (time <= h) {
                r = m - 1;
                k = Math.min(k, m);
            } else {
                l = m + 1;
            }
        }

        return k;
    }
}