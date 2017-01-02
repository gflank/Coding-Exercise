
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        
        int num = strs.length;
        // get the minimum length of string, O(n)
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < num; ++i) {
            minLen = Math.min(minLen, strs[i].length());
        }
        
        // check whether all string has same character, O(n^2)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLen; ++i) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < num; ++j) {
                if (strs[j].charAt(i) != cur) {
                    return result.toString();
                }
            }
            result.append(cur);
        }
        return result.toString();
    }
}
