public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        
        // not possible to have less than 4 or more than 12 numbers
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        // dfs helper, last argument is for the starting position
        dfsGainIP(res, path, s, 0);
        
        return res;
    }
    
    private void dfsGainIP(List<String> res, List<String> path, String s, int start) {
        // if reach the last ip section, check valid
        if (path.size() == 4) {
            if (start != s.length()) {
                return;
            }
            
            // concatenate all sections into an IP address
            StringBuilder sb = new StringBuilder(path.get(0));
            for (int i = 1; i < 4; ++i) {
                sb.append('.');
                sb.append(path.get(i));
            }
            res.add(sb.toString());
        }
        
        // check valid and add sections into path
        for (int i = start; i < start + 3 && i < s.length(); ++i) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                path.add(tmp);
                dfsGainIP(res, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isValid(String tmp) {
        // sections like 01, 001 are not valid
        if (tmp.charAt(0) == '0') {
            return tmp.equals("0");
        }
        
        // must be smaller than 256
        int num = Integer.parseInt(tmp);
        return num < 256;
    }
}
