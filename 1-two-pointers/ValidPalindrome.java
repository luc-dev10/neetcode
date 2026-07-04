
/**
 * https://neetcode.io/problems/is-palindrome/question?list=neetcode150
 * 
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s is made up of only printable ASCII characters.
 * 
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0;
        int r = cs.length - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(cs[l])) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(cs[r])) {
                r--;
                continue;
            }

            if (Character.toLowerCase(cs[l]) != Character.toLowerCase(cs[r])) return false;

            l++;
            r--;
        }

        return true;
    }
}