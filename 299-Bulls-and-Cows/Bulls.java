// one passes
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int curS = secret.charAt(i);
            int curG = guess.charAt(i);
            if (curS == curG) {
                ++bull;
            }
            else {
                if (map[curS - '0'] < 0) {
                    ++cow;
                }
                if (map[curG - '0'] > 0) {
                    ++cow;
                }
                map[curS - '0']++;
                map[curG - '0']--;
            }
        }
        return new String(bull + "A" + cow + "B");
    }
}

// two passes
// public class Solution {
//     public String getHint(String secret, String guess) {
//         int bull = 0, cow = 0;
//         int[] sMap = new int[10];
//         int[] gMap = new int[10];
//         for (int i = 0; i < secret.length(); ++i) {
//             char curS = secret.charAt(i);
//             char curG = guess.charAt(i);
//             if (curS == curG) {
//                 ++bull;
//             }
//             else {
//                 ++sMap[curS - '0'];
//                 ++gMap[curG - '0'];
//             }
//         }
//         for (int i = 0; i < 10; ++i) {
//             cow += Math.min(sMap[i], gMap[i]);
//         }
//         return new String(bull + "A" + cow + "B");
//     }
// }

// array version
// public class Solution {
//     public String getHint(String secret, String guess) {
//         int bull = 0, cow = 0;
//         int[] map = new int[10];
//         for (int i = 0; i < secret.length(); ++i) {
//             char cur = secret.charAt(i);
//             map[cur - '0']++;
//         }
//         for (int i = 0; i < secret.length(); ++i) {
//             char curSecret = secret.charAt(i);
//             char curGuess = guess.charAt(i);
//             if (curSecret == curGuess) {
//                 bull++;
//                 map[curSecret - '0']--;
//             }
//         }
//         for (int i = 0; i < secret.length(); ++i) {
//             char curSecret = secret.charAt(i);
//             char curGuess = guess.charAt(i);
//             if (curSecret == curGuess) {
//                 continue;
//             }
//             if (map[curGuess - '0'] > 0) {
//                 cow++;
//                 map[curGuess - '0']--;
//             }
//         }
//         return new String(bull + "A" + cow + "B");
//     }
// }


// pretty slow verstion
// public class Solution {
//     public String getHint(String secret, String guess) {
//         int bull = 0, cow = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < secret.length(); ++i) {
//             char cur = secret.charAt(i);
//             if (map.containsKey(cur)) {
//                 map.put(cur, map.get(cur) + 1);
//             }
//             else {
//                 map.put(cur, 1);
//             }
//         }
//         for (int i = 0; i < secret.length(); ++i) {
//             char curSecret = secret.charAt(i);
//             char curGuess = guess.charAt(i);
//             if (curSecret == curGuess) {
//                 bull++;
//                 map.put(curSecret, map.get(curSecret) - 1);
//             }
//         }
//         for (int i = 0; i < secret.length(); ++i) {
//             char curSecret = secret.charAt(i);
//             char curGuess = guess.charAt(i);
//             if (curSecret == curGuess) {
//                 continue;
//             }
//             if (map.containsKey(curGuess)) {
//                 int count = map.get(curGuess);
//                 if (count > 0) {
//                     ++cow;
//                     map.put(curGuess, count - 1);
//                 }
//             }
//         }
//         return new String(bull + "A" + cow + "B");
//     }
// }