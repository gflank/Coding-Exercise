import java.util.*;

public class Longest {
    // hashmap version
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 1, start = 0;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    // rewrote hashset version
    // public int lengthOfLongestSubstring(String s) {
    //     if (s.length() <= 1) {
    //         return s.length();
    //     }
        
    //     HashSet<Character> set = new HashSet<>();
    //     set.add(s.charAt(0));
    //     int max = 1, start = 0;
    //     for (int i = 1; i < s.length(); ++i) {
    //         char cur = s.charAt(i);
    //         if (!set.contains(cur)) {
    //             set.add(cur);
    //         }
    //         else {
    //             while (s.charAt(start) != cur) {
    //                 set.remove(s.charAt(start));
    //                 ++start;
    //             }
    //             ++start;
    //         }
    //         max = Math.max(max, i - start + 1);
    //     }
    //     return max;
    // }

    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null || s.length() == 0 || s.equals("")) {
    //     	return 0;
    //     }

    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //     int max = 1;
    //     int i = 0;
    //     int j = 0;
    // 	while (j < s.length()) {
    //     	if (!map.containsKey(s.charAt(j))) {
    //     		map.put(s.charAt(j), j);
    //     		max = Math.max(max, j - i + 1);
    //     		++j;
    //     	}
    //     	else {
    //     		while (map.containsKey(s.charAt(j))) {
    //     			map.remove(s.charAt(i));
    //     			++i;
    //     		}
    //     	}
    // 	}

    //     return max;
    // }

    // public static void main(String[] args) {
    // 	Longest A = new Longest();
    // 	String s = "cdd";
    // 	System.out.println(A.lengthOfLongestSubstring(s));
    // }
}

// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len = s.length();
//         if (len == 0) {
//             return 0;
//         }
        
//         HashSet<Character> set = new HashSet<Character>();
//         Queue<Character> queue = new LinkedList<Character>();
//         int max = 0;
        
//         for (int i = 0; i < len; ++i) {
//             char cur = s.charAt(i);
//             if (!set.contains(cur)) {
//                 queue.offer(cur);
//                 set.add(cur);
//                 max = Math.max(max, queue.size());
//             }
//             else {
//                 while (!queue.isEmpty() && set.contains(cur)) {
//                     char polled = queue.poll();
//                     set.remove(polled);
//                 }
//                 queue.offer(cur);
//                 set.add(cur);
//                 max = Math.max(max, queue.size());
//             }
//         }
        
//         return max;
//     }
// }