/**
 * https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Constraints:
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains any possible characters out of 256 valid ASCII characters.
 * 
 */
public class EncodeAndDecodeStrings {
   public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() == 0) return res;

        int l = 0;
        while (l < str.length()) {
            int r = l + 1;
            while (str.charAt(r) != '#') r++;
            int s = r + 1;
            int e = s + Integer.parseInt(str.substring(l, r));
            res.add(str.substring(s, e));
            l = e;
        }

        return res;
    }
}
