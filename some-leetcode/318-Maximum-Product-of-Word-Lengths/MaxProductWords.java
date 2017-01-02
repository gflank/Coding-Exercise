// bit mask version, O(n^2)
public class Solution {
    public int maxProduct(String[] words) {
        if (words.length <= 1) {
            return 0;
        }
        
        // compress the string first
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        
        int max = 0;
        for (int i = 0; i < words.length - 1; ++i) {
            // now start to loop over next posible word
            for (int j = i + 1; j < words.length; ++j) {
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

// slow version, O(nlgn + n^2 * k)
public class Solution {
    public int maxProduct(String[] words) {
        if (words.length <= 1) {
            return 0;
        }
        // first sort the words based on length, descending order
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        
        int max = 0;
        for (int i = 0; i < words.length - 1; ++i) {
            int len1 = words[i].length();
            // pruing tail
            if (len1 * len1 <= max) {
                break;
            }
            //now record all letter using int[]
            boolean[] letters = new boolean[26];
            for (int index = 0; index < len1; ++index) {
                letters[words[i].charAt(index) - 'a'] = true;
            }
            
            // now start to loop over next posible word
            for (int j = i + 1; j < words.length; ++j) {
                // first check if there is intersection
                boolean noIntersect = true;
                for (int index = 0; index < words[j].length(); ++index) {
                    if (letters[words[j].charAt(index) - 'a'] == true) {
                        noIntersect = false;
                        break;
                    }
                }
                if (noIntersect) {
                    max = Math.max(max, len1 * words[j].length());
                    // pruing tail
                    break;
                }
            }
        }
        return max;
    }
}

// not work version
// public class Solution {
//     public int maxProduct(String[] words) {
//         if (words.length <= 1) {
//             return 0;
//         }
//         // first sort the words based on length, descending order
//         Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        
//         int max = 0;
//         int i1 = 0, i2 = 1;
//         while (i1 < words.length - 1 && i2 < words.length) {
//             System.out.println(words[i1] + " " + words[i2]);

//             int len1 = words[i1].length();
//             //now record all letter using int[]
//             boolean[] letters = new boolean[26];
//             for (int index = 0; index < len1; ++index) {
//                 letters[words[i1].charAt(index) - 'a'] = true;
//             }
            
//             int len2 = words[i2].length();
//             // first check if there is intersection
//             boolean noIntersect = true;
//             for (int index = 0; index < words[i2].length(); ++index) {
//                 if (letters[words[i2].charAt(index) - 'a'] == true) {
//                     noIntersect = false;
//                     break;
//                 }
//             }
//             if (noIntersect) {
//                 return len1 * len2;
//             }
            
//             // if not qualify, now deside next step
//             if (i1 + 1 == i2) {
//                 ++i2;
//             }
//             else if (i2 + 1 < words.length && len1 * words[i2 + 1].length() < words[i1 + 1].length() * len2) {
//                 ++i1;
//             }
//             else {
//                 ++i2;
//             }
//         }

//         return max;
//     }
// }