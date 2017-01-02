// refer other's solution
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtrack(word, res, 0, "", 0);
        return res;
    }
    
    private void backtrack(String word, List<String> res, int pos, String prev, int count) {
        // if reach the end
        if (pos == word.length()) {
            if (count > 0) {
                prev += count;
            }
            res.add(prev);
        }
        else {
            // two direction, abbreviate current character or not
            backtrack(word, res, pos + 1, prev, count + 1);
            // if not abbreviate current char, check the count and append current char
            if (count > 0) {
                prev += count;
            }
            prev += word.charAt(pos);
            backtrack(word, res, pos + 1, prev, 0);
        }
    }
}

// wrong version
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        res.add(word);
        res.add("" + word.length());
        if (word.length() == 0) {
            return res;
        }
        for (int i = 1; i < word.length(); ++i) {
            for (int j = 0; j + i < word.length(); ++j) {
                StringBuilder cur = new StringBuilder();
                for (int k = 0; k < j; ++k) {
                    cur.append(word.charAt(k));
                }
                cur.append(i);
                for (int k = j + i; k < word.length(); ++k) {
                    cur.append(word.charAt(k));
                }
                res.add(cur.toString());
            }
        }
        return res;
    }
}