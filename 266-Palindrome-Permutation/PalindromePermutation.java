
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; ++i) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            }
            else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        
        int odd = 0;
        for (int count : map.values()) {
            if (count % 2 != 0) {
                odd++;
                if (odd > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
