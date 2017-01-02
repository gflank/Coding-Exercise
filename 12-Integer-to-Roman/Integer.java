public class Solution {
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < romans.length) {
            if (num >= values[index]) {
                num -= values[index];
                res.append(romans[index]);
            }
            else {
                ++index;
            }
        }
        return res.toString();
    }
}