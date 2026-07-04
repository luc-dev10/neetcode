/*
 * https://neetcode.io/problems/anagram-groups/question?list=neetcode150
 *
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * 
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Constraints:

 * 1 <= strs.length <= 1000.
 * 0 <= strs[i].length <= 100
 * strs[i] is made up of lowercase English letters.
 *
*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {
            int[] k = new int[26];
            for (int i = 0; i < s.toCharArray().length; i++) {
                k[s.charAt(i) - 'a'] += 1;
            }
            String ck = Arrays.toString(k);
            List<String> v = hm.getOrDefault(ck, new ArrayList<>());
            v.add(s);
            hm.put(ck, v);
        }

        return new ArrayList<>(hm.values());
    }
}