public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = Integer.MAX_VALUE, pos2 = Integer.MAX_VALUE;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                pos1 = i;
                dis = Math.min(dis, Math.abs(pos1 - pos2));
            }
            else if (words[i].equals(word2)) {
                pos2 = i;
                dis = Math.min(dis, Math.abs(pos1 - pos2));
            }
        }
        
        return dis;
    }
}


// public class Solution {
//     public int shortestDistance(String[] words, String word1, String word2) {
//         int index1 = -1, index2 = -1, min = Integer.MAX_VALUE, flag = 0;
        
//         for (int i = 0; i < words.length; ++i) {
//             if (words[i].equals(word1)) {
//                 index1 = i;
//                 flag = 1;
//             }
//             else if (words[i].equals(word2)) {
//                 index2 = i;
//                 flag = 1;
//             }
//             if (flag == 1) {
//                 flag = 0;
//                 if (index1 != -1 && index2 != -1) {
//                     int diff = Math.abs(index1 - index2);
//                     if (diff < min) {
//                         min = diff;
//                     }                    
//                 }

//             }
//         }
        
//         return min;
//     }
// }
