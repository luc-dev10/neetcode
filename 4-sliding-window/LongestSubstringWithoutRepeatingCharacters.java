/**
 * 
 * https://neetcode.io/problems/longest-substring-without-duplicates/question?list=neetcode150
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * Constraints:
 * 0 <= s.length <= 50,000
 * s may consist of printable ASCII characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int t =  0;
        while (r < s.length()) {
            if (hm.containsKey(s.charAt(r))) l = Math.max(l, hm.get(s.charAt(r)) + 1);
            t = Math.max(t, r - l + 1);
            hm.put(s.charAt(r), r);
            r++;
        }

        return t;
    }
}