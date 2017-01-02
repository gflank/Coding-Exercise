import java.util.*;

public class Alien {   
    public static String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        
        HashMap<Character, Integer> degrees = new HashMap<>();
        // set to store the desendents for each letter
        HashMap<Character, HashSet<Character>> descendents = new HashMap<>();
        
        // initialize the degrees map
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                char cur = word.charAt(i);
                if (!degrees.containsKey(cur)) {
                    degrees.put(cur, 0);
                }
            }
        }
        
        // calculate the degree for each letter
        for (int i = 0; i < words.length - 1; ++i) {
            // check the dependency between letters
            int len = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < len; ++j) {
                char former = words[i].charAt(j);
                char latter = words[i + 1].charAt(j);
                if (former != latter) {
                    // maintain the descendents set
                    HashSet<Character> des;
                    if (descendents.containsKey(former)) {
                        des = descendents.get(former);
                    }
                    else {
                        des = new HashSet<>();
                        descendents.put(former, des);
                    }
                    if (!des.contains(latter)) {
                        des.add(latter);
                        // increase latter letter's degree
                        // increment the degree only if this dependency relation has not been discovered before
                        degrees.put(latter, degrees.get(latter) + 1);
                    }
                    // only the first different is valid
                    break;
                }
            }
        }
        
        // generate the order according to degrees
        StringBuilder res = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // add all letter with degree 0 into queue
        for (char letter : degrees.keySet()) {
            if (degrees.get(letter) == 0) {
                queue.add(letter);
            }
        }
        // start bfs
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            if (descendents.containsKey(cur)) {
                HashSet<Character> set = descendents.get(cur);
                // decrement the degree of its descendents
                for (char des : set) {
                    int desDegree = degrees.get(des) - 1;
                    // add to queue if free from dependency
                    if (desDegree == 0) {
                        queue.add(des);
                    }
                    degrees.put(des, desDegree);
                }
            }
        }
        // check for cycle in the graph
        if (res.length() != degrees.size()) {
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"za","zb","ca","cb"};
        System.out.println(Alien.alienOrder(words));
    }
}