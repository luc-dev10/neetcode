/**
 * 
 * https://neetcode.io/problems/minimum-window-with-characters/question?list=neetcode150
 * 
 * Given two strings s and t, return the shortest substring of s such that every character in t, 
 * including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
 * You may assume that the correct output is always unique.
 * 
 * Constraints:
 * 1 <= s.length <= 100,000
 * 1 <= t.length <= 100,000
 * s and t consist of uppercase and lowercase English letters.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> reqHm = new HashMap<>();
        Map<Character, Integer> windowHm = new HashMap<>();
        for (char c : t.toCharArray()) reqHm.put(c, reqHm.getOrDefault(c, 0) + 1);

        int wc = 0;
        int rc = reqHm.size();
        int l = 0;
        int rl = 0;
        int rr = 0;
        int tl = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char k = s.charAt(r);
            windowHm.put(k, windowHm.getOrDefault(k, 0) + 1);
            if (reqHm.containsKey(k) && windowHm.get(k).equals(reqHm.get(k))) wc++;

            while (wc == rc) {
                int w = r - l + 1;
                if (w < tl) {
                    tl = w;
                    rl = l;
                    rr = r;
                }

                k = s.charAt(l);
                if (reqHm.containsKey(k) && windowHm.get(k).equals(reqHm.get(k))) wc--;
                windowHm.put(k, windowHm.getOrDefault(k, 0)  - 1);
                l++;
            }
        }

        return tl == Integer.MAX_VALUE ? "" : s.substring(rl, rr + 1);
    }
}
