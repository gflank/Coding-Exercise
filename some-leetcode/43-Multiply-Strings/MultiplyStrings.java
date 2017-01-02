// neat version without invalid check
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        // if either 0
        if (num1.charAt(0) - '0' == 0 || num2.charAt(0) - '0' == 0) {
            return "0";
        }
        
        // assume the maximum len
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            char cur1 = num1.charAt(i);
            for (int j = num2.length() - 1; j >= 0; --j) {
                char cur2 = num2.charAt(j);
                // now starting to do multiplication
                int curIndex = i + j + 1;
                int product = (cur1 - '0') * (cur2 - '0');
                res[curIndex] += product;
                res[curIndex - 1] += res[curIndex] / 10;
                res[curIndex] = res[curIndex] % 10;
            }
        }
        
        // now output the res
        StringBuilder output = new StringBuilder();
        int startPos = 0;
        // skip the head zero
        if (res[0] == 0) {
            ++startPos;
        }
        while (startPos < res.length) {
            output.append(res[startPos++]);
        }
        return output.toString();
    }
}

// a little neater version
// public class Solution {
//     public String multiply(String num1, String num2) {
//         if (num1.length() == 0 || num2.length() == 0) {
//             return "";
//         }
//         // first skip all the zeros from the head
//         int pos1 = 0, pos2 = 0;
//         for (int i = 0; i < num1.length(); ++i) {
//             char cur = num1.charAt(i);
//             // if invalid
//             if (!checkValid(cur)) {
//                 return "";
//             }
//             else if (cur == '0') {
//                 ++pos1;
//             }
//             //if non zero
//             break;
//         }
//         for (int i = 0; i < num2.length(); ++i) {
//             char cur = num2.charAt(i);
//             // if invalid
//             if (cur > '9' || cur < '0') {
//                 return "";
//             }
//             else if (cur == '0') {
//                 ++pos2;
//             }
//             //if non zero
//             break;
//         }
//         // if any one is all zeroes
//         if (pos1 == num1.length() || pos2 == num2.length()) {
//             return "0";
//         }
        
//         // use the length of remain numbers to decide how many bits we might have
//         // assume the maximum len
//         int[] res = new int[num1.length() - pos1 + num2.length() - pos2];
//         for (int i = num1.length() - 1; i >= pos1; --i) {
//             char cur1 = num1.charAt(i);
//             // check invalid
//             if (!checkValid(cur1)) {
//                 return "";
//             }
//             for (int j = num2.length() - 1; j >= pos2; --j) {
//                 char cur2 = num2.charAt(j);
//                 // check invalid
//                 if (!checkValid(cur2)) {
//                     return "";
//                 }
//                 // now starting to do multiplication
//                 int curIndex = i - pos1 + j - pos2 + 1;
//                 int product = (cur1 - '0') * (cur2 - '0');
//                 res[curIndex] += product;
//                 res[curIndex - 1] += res[curIndex] / 10;
//                 res[curIndex] = res[curIndex] % 10;
//             }
//         }
        
//         // now output the res
//         StringBuilder output = new StringBuilder();
//         int startPos = 0;
//         // skip the head zeros
//         while (res[startPos] == 0) {
//             ++startPos;
//         }
//         while (startPos < res.length) {
//             output.append(res[startPos++]);
//         }
//         return output.toString();
//     }
    
//     private boolean checkValid(char num) {
//         // check invalid
//         if (num > '9' || num < '0') {
//             return false;
//         }
//         return true;
//     }
// }



// public class Solution {
//     public String multiply(String num1, String num2) {
//         if (num1.length() == 0 || num2.length() == 0) {
//             return "";
//         }
//         // first skip all the zeros from the head
//         int pos1 = 0, pos2 = 0;
//         for (int i = 0; i < num1.length(); ++i) {
//             char cur = num1.charAt(i);
//             // if invalid
//             if (!checkValid(cur)) {
//                 return "";
//             }
//             else if (cur == '0') {
//                 ++pos1;
//             }
//             //if non zero
//             break;
//         }
//         for (int i = 0; i < num2.length(); ++i) {
//             char cur = num2.charAt(i);
//             // if invalid
//             if (cur > '9' || cur < '0') {
//                 return "";
//             }
//             else if (cur == '0') {
//                 ++pos2;
//             }
//             //if non zero
//             break;
//         }
//         // if any one is all zeroes
//         if (pos1 == num1.length() || pos2 == num2.length()) {
//             return "0";
//         }
        
//         // use the length of remain numbers to decide how many bits we might have
//         // assume the maximum len
//         int[] res = new int[num1.length() - pos1 + num2.length() - pos2];
//         for (int i = num1.length() - 1; i >= pos1; --i) {
//             char cur1 = num1.charAt(i);
//             // check invalid
//             if (!checkValid(cur1)) {
//                 return "";
//             }
//             for (int j = num2.length() - 1; j >= pos2; --j) {
//                 char cur2 = num2.charAt(j);
//                 // check invalid
//                 if (!checkValid(cur2)) {
//                     return "";
//                 }
//                 // now starting to do multiplication
//                 int product = (cur1 - '0') * (cur2 - '0');
//                 int carry = product / 10;
//                 product = product % 10;
//                 // put the local product into result
//                 res[i - pos1 + j - pos2 + 1] += product;
//                 // remember to handle the carry bit
//                 handleCarry(i - pos1 + j - pos2 + 1, res);
//                 res[i - pos1 + j - pos2] += carry;
//                 handleCarry(i - pos1 + j - pos2, res);
//             }
//         }
        
//         // now output the res
//         StringBuilder output = new StringBuilder();
//         int startPos = 0;
//         // skip the head zeros
//         while (res[startPos] == 0) {
//             ++startPos;
//         }
//         while (startPos < res.length) {
//             output.append(res[startPos++]);
//         }
//         return output.toString();
//     }
    
//     private boolean checkValid(char num) {
//         // check invalid
//         if (num > '9' || num < '0') {
//             return false;
//         }
//         return true;
//     }
    
//     private void handleCarry(int index, int[] product) {
//         while (product[index] >= 10) {
//             int carry = product[index] / 10;
//             product[index] = product[index] % 10;
//             product[--index] += carry;
//         }
//     }
// }