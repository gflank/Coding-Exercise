public class WordDistance {
    String[] list;
    // HashMap<String, Integer> history;
    HashMap<String, List<Integer>> prepare;

    public WordDistance(String[] words) {
        list = words;
        // history = new HashMap<>();
        // put all the indices into prepare hashmap
        prepare = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            List<Integer> indices;
            if (prepare.containsKey(words[i])) {
                indices = prepare.get(words[i]);
            }
            else {
                indices = new ArrayList<Integer>();
                prepare.put(words[i], indices);
            }
            indices.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        // if (history.containsKey(word1 + "," + word2)) {
        //     return history.get(word1 + "," + word2);
        // }
        // else if (history.containsKey(word2 + "," + word1)) {
        //     return history.get(word2 + "," + word1);
        // }
        
        int pos1 = 0, pos2 = 0, dis = Integer.MAX_VALUE;
        List<Integer> list1 = prepare.get(word1), list2 = prepare.get(word2);
        while (pos1 < list1.size() && pos2 < list2.size()) {
            int index1 = list1.get(pos1);
            int index2 = list2.get(pos2);
            dis = Math.min(dis, Math.abs(index1 - index2));
            if (dis == 1) {
                break;
            }
            if (index1 < index2) {
                ++pos1;
            }
            else {
                ++pos2;
            }
        }
        
        // history.put(word1 + "," + word2, dis);
        // history.put(word2 + "," + word1, dis);
        return dis;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");