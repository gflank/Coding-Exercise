
public class Solution {
    /*
    // misunderstood the question
    public String countAndSay(int n) {
        if (n < 10) {
            String result = "";
            result += n;
            return result;
        }
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // store all the numbers into list
        while (n != 0) {
            int num = n % 10;
            nums.add(num);
            n /= 10;
        }
        
        StringBuilder result = new StringBuilder();
        int count = 1, index = nums.size() - 1, last = nums.get(0);
        while (index >= 0) {
            if (index - 1 < 0 || nums.get(index) != nums.get(index - 1)) {
                String temp = "";
                temp += String.valueOf(count) + String.valueOf(last);
                result.append(temp);
                count = 1;
            }
            else {
                last = nums.get(index);
                ++count;
            }
            --index;
        }
        
        return result.toString();
    }
    */
    
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        else if (n == 1) {
            return "1";
        }
        
        String result = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder temp = new StringBuilder();
            int lastIndex = 0;
            for (int j = 0; j < result.length(); ++j) {
                if (result.charAt(lastIndex) != result.charAt(j)) {
                    temp.append(j - lastIndex);
                    temp.append(result.charAt(lastIndex));
                    lastIndex = j;
                }
            }
            temp.append(result.length() - lastIndex);
            temp.append(result.charAt(lastIndex));
            result = temp.toString();
        }
        
        return result;
    }
}
