
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        int len = beginWord.length();
        if (len == 0) {
            return new ArrayList<List<String>>();
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
        
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        List<List<String>> allPaths = new ArrayList<List<String>>();
        allPaths.add(path);
        
        map.put(beginWord, allPaths);
        queue.offer(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // create a temp map for each level
            HashMap<String, List<List<String>>> tempMap = new HashMap<String, List<List<String>>>();
            
            for (int i = 0; i < size; ++i)   {
                String cur = queue.poll();
                
                for (int j = 0; j < cur.length(); ++j) {
                    
                    for (char changed = 'a'; changed <= 'z'; ++changed) {
                        char[] chars = cur.toCharArray();
                        chars[j] = changed;
                        String temp = new String(chars);
                        
                        // notice that endWord may be out of the given wordList
                        // check the new created word is in dictionary and is never been visited(except current level)
                        if (!map.containsKey(temp) && (wordList.contains(temp) || temp.equals(endWord))) {
                            // take out previous word's paths
                            List<List<String>> prePaths = map.get(cur);
                            
                            List<List<String>> curPaths = tempMap.get(temp);
                            // if never been visited, create one and put it into queue
                            if (curPaths == null) {
                                queue.offer(temp);
                                curPaths = new ArrayList<List<String>>();
                                tempMap.put(temp, curPaths);
                            }
                            
                            // start to add current path to tempMap
                            for (List<String> single : prePaths) {
                                // create new path
                                List<String> newSingle = new ArrayList<String>(single);
                                newSingle.add(temp);
                                curPaths.add(newSingle);
                            }
                        }
                    }
                }
            }
            
            // check whether reached end after each level
            if (map.containsKey(endWord)) {
                return map.get(endWord);
            }
            
            map.putAll(tempMap);
        }
        
        return new ArrayList<List<String>>();
    }
}
