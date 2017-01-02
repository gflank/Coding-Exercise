// array version
class TrieNode {
    // Initialize your data structure here.
    public boolean isWord;
    public TrieNode[] children;
    
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                TrieNode child = new TrieNode();
                cur.children[pos] = child;
                cur = child;
            }
            else {
                cur = cur.children[pos];
            }
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            else {
                cur = cur.children[pos];
            }
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int pos = prefix.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            else {
                cur = cur.children[pos];
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

// hashmap version
// class TrieNode {
//     // Initialize your data structure here.
//     public boolean isWord;
//     public HashMap<Character, TrieNode> children;
    
//     public TrieNode() {
//         isWord = false;
//         children = new HashMap<>();
//     }
// }

// public class Trie {
//     private TrieNode root;

//     public Trie() {
//         root = new TrieNode();
//     }

//     // Inserts a word into the trie.
//     public void insert(String word) {
//         TrieNode cur = root;
//         for (int i = 0; i < word.length(); ++i) {
//             if (!cur.children.containsKey(word.charAt(i))) {
//                 TrieNode child = new TrieNode();
//                 cur.children.put(word.charAt(i), child);
//                 cur = child;
//             }
//             else {
//                 cur = cur.children.get(word.charAt(i));
//             }
//         }
//         cur.isWord = true;
//     }

//     // Returns if the word is in the trie.
//     public boolean search(String word) {
//         TrieNode cur = root;
//         for (int i = 0; i < word.length(); ++i) {
//             if (!cur.children.containsKey(word.charAt(i))) {
//                 return false;
//             }
//             else {
//                 cur = cur.children.get(word.charAt(i));
//             }
//         }
//         return cur.isWord;
//     }

//     // Returns if there is any word in the trie
//     // that starts with the given prefix.
//     public boolean startsWith(String prefix) {
//         TrieNode cur = root;
//         for (int i = 0; i < prefix.length(); ++i) {
//             if (!cur.children.containsKey(prefix.charAt(i))) {
//                 return false;
//             }
//             else {
//                 cur = cur.children.get(prefix.charAt(i));
//             }
//         }
//         return cur.isWord || cur.children.size() > 0;
//     }
// }

// // Your Trie object will be instantiated and called as such:
// // Trie trie = new Trie();
// // trie.insert("somestring");
// // trie.search("key");