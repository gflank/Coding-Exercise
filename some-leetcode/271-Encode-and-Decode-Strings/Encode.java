public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String cur : strs) {
            sb.append(cur.length()).append("/").append(cur);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int pos = 0;
        while (pos < s.length()) {
            int slash = pos + 1;
            while (s.charAt(slash) != '/') {
                ++slash;
            }
            int len = Integer.valueOf(s.substring(pos, slash));
            res.add(s.substring(slash + 1, slash + 1 + len));
            pos = slash + 1 + len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));