public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        // copy the string first
        StringBuffer sb = new StringBuffer(s);
        String replace = "--";
        String replaceBack = "++";
        
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                // trigger a replacement action
                sb.replace(i, i + 2, replace);
                res.add(sb.toString());
                sb.replace(i, i + 2, replaceBack);
            }
        }
        
        return res;
    }
}
