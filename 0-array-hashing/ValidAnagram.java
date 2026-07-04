/**
 * https://neetcode.io/problems/is-anagram/question?list=neetcode150
 * 
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * 
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * 
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!hm.containsKey(c)) return false;
            if (hm.get(c) == 1) hm.remove(c);
            else hm.put(c, hm.get(c) - 1);
        }

        return hm.isEmpty();
    }
}