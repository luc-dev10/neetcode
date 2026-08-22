/**
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement/question?list=neetcode150
 *
 * You are given a string s consisting of only uppercase english characters and an integer k.
 * 
 * You can choose up to k characters of the string and replace them with any other uppercase English character.
 * 
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100,000
 * 0 <= k <= s.length
 * s consists of only uppercase english characters.
 * 
 * */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] a = new int[26];
        int l = 0;
        int hc = 0;
        int t = 0;

        for (int r = 0; r < s.length(); r++) {
            int p = s.charAt(r) - 'A';
            a[p]++;
            hc = Math.max(hc, a[p]);

            while (r - l + 1 - hc > k) {
                a[s.charAt(l) - 'A']--;
                l++;
                // for (int i = 0; i < a.length; i++) hc = Math.max(hc, a[i]);
            }

            t = Math.max(t, r - l + 1);
        }

        return t;
    }
}
