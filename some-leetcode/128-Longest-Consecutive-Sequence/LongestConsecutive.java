// one scan version
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        // hashmap storing the max consecutive number for current value
        // some of them might be stale, but does not matter cause they would not be accessed any more
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = 0, right = 0;
                if (map.containsKey(num - 1)) {
                    left = map.get(num - 1);
                }
                if (map.containsKey(num + 1)) {
                    right = map.get(num + 1);
                }
                
                int sum = left + right + 1;
                map.put(num, sum);
                // update the boundary elements;
                map.put(num - left, sum);
                map.put(num + right, sum);
                
                max = Math.max(sum , max);
            }
        }
        return max;
    }
}

// bfs with hashset, still slow 21ms
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        
        int max = 1;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(num);
            int localMax = 1;
            set.remove(num);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                // check the neighbours
                if (set.contains(cur - 1)) {
                    ++localMax;
                    set.remove(cur - 1);
                    queue.offer(cur - 1);
                }
                if (set.contains(cur + 1)) {
                    ++localMax;
                    set.remove(cur + 1);
                    queue.offer(cur + 1);
                }
            }
            max = Math.max(max, localMax);
        }
        return max;
    }
}

// bfs, accepted but slow 28ms
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, false);
            }
        }
        
        int max = 1;
        for (int num : map.keySet()) {
            if (map.get(num) == true) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(num);
            int localMax = 1;
            map.put(num, true);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (map.containsKey(cur - 1) && map.get(cur - 1) == false) {
                    ++localMax;
                    map.put(cur - 1, true);
                    queue.offer(cur - 1);
                }
                if (map.containsKey(cur + 1) && map.get(cur + 1) == false) {
                    ++localMax;
                    map.put(cur + 1, true);
                    queue.offer(cur + 1);
                }
            }
            max = Math.max(max, localMax);
        }
        return max;
    }
}


// dfs, stack overflow
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, false);
            }
        }
        
        int max = 1;
        for (int num : map.keySet()) {
            max = Math.max(max, dfs(map, num, 0));
        }
        return max;
    }
    
    private int dfs(HashMap<Integer, Boolean> map, int num, int count) {
        if (map.containsKey(num) && map.get(num) == false) {
            map.put(num, true);
            return Math.max(dfs(map, num - 1, count + 1), dfs(map, num + 1, count + 1));
        }
        else {
            return count;
        }
    }
}