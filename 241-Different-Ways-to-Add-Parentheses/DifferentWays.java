public class Solution {
    // incomplete codes
    // List<Character> opes;
    // List<Character> nums;

    // public List<Integer> diffWaysToCompute(String input) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     if (input.length() == 0) {
    //         return res;
    //     }
        
    //     // store all numbers and operators
    //     opes = new ArrayList<Character>();
    //     nums = new ArrayList<Character>();
    //     int lastOpe = -1;
    //     for (int i = 0; i < input.length(); ++i) {
    //         if (input.charAt(i) > '9' || input.charAt(i) < '0') {
    //             opes.add(input.charAt(i));
    //             // convert and store the former number
    //             nums.add(Integer.parseInt(input.substring(lastOpe + 1, i)));
    //             lastOpe = i;
    //         }
    //     }
    //     // store the last number
    //     nums.add(Integer.parseInt(input.substring(lastOpe + 1, input.length())));
        
    //     if (opes.size() == 0) {
    //         res.add(nums.get(0));
    //         return res;
    //     }
        
    //     return helper(0, nums.length() - 1);
    // }
    
    // private List<Integer> helper(int start, int end) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     if (start == end) {
    //         res.add(nums.get(start));
    //         return res;
    //     }
        
    //     for (int ) {
            
    //     }
    // }
    
    // recursive version
    // public List<Integer> diffWaysToCompute(String input) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     for (int i = 0; i < input.length(); ++i) {
    //         if (input.charAt(i) > '9' || input.charAt(i) < '0') {
    //             String partA = input.substring(0, i);
    //             String partB = input.substring(i + 1);
    //             List<Integer> resA = diffWaysToCompute(partA);
    //             List<Integer> resB = diffWaysToCompute(partB);
    //             for (int numA : resA) {
    //                 for (int numB : resB) {
    //                     int comp = 0;
    //                     switch (input.charAt(i)) {
    //                         case '+':
    //                             comp = numA + numB;
    //                             break;
    //                         case '-':
    //                             comp = numA - numB;
    //                             break;
    //                         case '*':
    //                             comp = numA * numB;
    //                             break;
    //                     }
    //                     res.add(comp);
    //                 }
    //             }
    //         }
    //     }
        
    //     if (res.size() == 0) {
    //         res.add(Integer.parseInt(input));
    //     }
    //     return res;
    // }
    
    // rewrite recursion (pre parse and memorize table)
    List<String> parsedInput;
    HashMap<String, List<Integer>> cache;
    
    public List<Integer> diffWaysToCompute(String input) {
        parsedInput = new ArrayList<String>();
        cache = new HashMap<String, List<Integer>>();
        int prev = -1;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                parsedInput.add(input.substring(prev + 1, i));
                parsedInput.add(input.substring(i, i + 1));
                prev = i;
            }
        }
        // store the last number
        parsedInput.add(input.substring(prev + 1, input.length()));
        
        List<Integer> res = getAll(0, parsedInput.size() - 1);
        
        return res;
    }
    
    private List<Integer> getAll(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        sb.append(',');
        sb.append(end);
        if (cache.containsKey(sb.toString())) {
            return cache.get(sb.toString());
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if (start == end) {
            res.add(Integer.parseInt(parsedInput.get(start)));
            return res;
        }
        
        for (int i = start; i <= end; ++i) {
            // if it is symbol
            if (i % 2 != 0) {
                List<Integer> resA = getAll(start, i - 1);
                List<Integer> resB = getAll(i + 1, end);
                for (int numA : resA) {
                    for (int numB : resB) {
                        int cal = 0;
                        switch (parsedInput.get(i)) {
                            case "+":
                                cal = numA + numB;
                                break;
                            case "-":
                                cal = numA - numB;
                                break;
                            case "*":
                                cal = numA * numB;
                                break;
                        }
                        res.add(cal);
                    }
                }
            }
        }
        
        cache.put(sb.toString(), res);
        return res;
    }
}