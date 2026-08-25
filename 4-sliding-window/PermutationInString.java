/**
 * https://neetcode.io/problems/permutation-string/question?list=neetcode150
 * 
 * You are given two strings s1 and s2.
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 * Both strings only contain lowercase letters.
 * 
 * Constraints:
 * 1 <= s1.length, s2.length <= 10000
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int l = 0;
        int c = s1.length();
        int[] a = new int[26];
        for (char i : s1.toCharArray()) a[i - 'a']++; 

        for (int r = 0; r < s2.length(); r++) {
            int k = s2.charAt(r) - 'a';
            if (a[k] > 0) c--;
            a[k]--;

            if (r - l + 1 > s1.length()) {
                k = s2.charAt(l) - 'a';
                a[k]++;
                if (a[k] > 0) c++;
                l++;
            }

            if (c == 0) return true;
        }

        return false;
    }
}