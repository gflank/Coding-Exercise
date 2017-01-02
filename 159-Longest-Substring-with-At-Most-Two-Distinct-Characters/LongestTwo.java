public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len <= 2) {
            return len;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < len; ++i) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            }
            else {
                while (map.size() == 2) {
                    int count = map.get(s.charAt(start)) - 1;
                    if (count == 0) {
                        map.remove(s.charAt(start));
                    }
                    else {
                        map.put(s.charAt(start), count);
                    }
                    ++start; 
                }
                map.put(cur, 1);
            }
            
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}


// leftMost version
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, i);
            }
            else {
                if (map.size() == 2) {
                    int leftMost = s.length();
                    for (int j : map.values()) {
                        leftMost = Math.min(leftMost, j);
                    }
                    map.remove(s.charAt(leftMost));
                    start = leftMost + 1;
                }
                map.put(cur, i);
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}


/*
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int curHead = 0;
        int max = 0;
        
        for (int i = 0; i < len; ++i) {
            char cur = s.charAt(i);
            // if the new char is not qualified for being added to the substring
            if (map.size() >= 2 && !map.containsKey(cur)) {
                while (map.size() >= 2) {
                    char head = s.charAt(curHead);
                    int count = map.get(head) - 1;
                    if (count == 0) {
                        map.remove(head);
                    }
                    else {
                        map.put(head, count);
                    }
                    ++curHead;
                }
            }
            // if it is originally qualified or now it is qualified
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            }
            else {
                map.put(cur, 1);
            }
            max = Math.max(max, i - curHead + 1);
        }
        
        return max;
    }
}
*/

// miss understood the question
// public class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         if (s.length() <= 2) {
//             return s.length();
//         }
        
//         HashMap<Character, Integer> map = new HashMap<>();
//         int max = 0, start = 0;
//         for (int i = 0; i < s.length(); ++i) {
//             if (!map.containsKey(s.charAt(i))) {
//                 map.put(s.charAt(i), 1);
//             }
//             else {
//                 if (map.get(s.charAt(i)) < 1) {
//                     map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//                 }
//                 else {
//                     while (s.charAt(start) != s.charAt(i)) {
//                         map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
//                         ++start;
//                     }
//                     ++start;
//                 }
//             }
//             max = Math.max(max, i - start + 1);
//         }
//         return max;
//     }
// }