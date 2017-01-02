public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        if (strings.length == 0) {
            return res;
        }
        
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < str.length(); ++i) {
                char tmp = (char)(str.charAt(i) - offset);
                // if upper case, convert to lower case
                // if out of range (like "cab"), convert to the tail
                if (tmp < 'a') {
                    tmp = (char)(tmp + 26);
                }
                sb.append(tmp);
            }
            
            String tmpKey = sb.toString();
            // check if this key exist
            if (!map.containsKey(tmpKey)) {
                // create a new list
                List<String> tmpList = new ArrayList<String>();
                map.put(tmpKey, tmpList);
            }
            
            // get the list and add the element
            map.get(tmpKey).add(str);
        }
        
        for (String key : map.keySet()) {
            List<String> tmpList = map.get(key);
            Collections.sort(tmpList);
            res.add(tmpList);
        }
        
        return res;
    }
}