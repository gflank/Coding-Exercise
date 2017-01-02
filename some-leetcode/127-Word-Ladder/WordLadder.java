
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int len = beginWord.length();
        if (len == 0) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        
        queue.offer(beginWord);
        set.add(beginWord);
        int shortest = 1;
        
        while (!queue.isEmpty()) {
            ++shortest;
            
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); ++j) {
                    for (char changed = 'a'; changed <= 'z'; ++changed) {
                        char[] chars = cur.toCharArray();
                        chars[j] = changed;
                        String temp = new String(chars);
                        
                        if (!set.contains(temp) && wordList.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return shortest;
                            }
                            queue.offer(temp);
                            set.add(temp);
                        }
                    }
                }

            }
        }
        
        return 0;
    }
}
