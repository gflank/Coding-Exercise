// rewrote, using one HashMap
public class ValidWordAbbr {
    // use HashMap<abbreviation, origin word> to indicate the relationship
    private HashMap<String, String> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (!dict.containsKey(abbr)) {
                dict.put(abbr, word);
            }
            else {
                // reset the origin word if not the same word
                if (!dict.get(abbr).equals(word)) {
                    dict.put(abbr, "");
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!dict.containsKey(abbr)) {
            return true;
        }
        // if abbreviation already exist, check if the origin word is the same as current word
        return dict.get(abbr).equals(word);
    }
    
    private String getAbbr(String word) {
        // no need to transform
        if (word.length() <= 2) {
            return word;
        }
        return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");

// public class ValidWordAbbr {
//     private HashMap<String, Boolean> abbrDict;
//     private HashSet<String> oriDict;

//     public ValidWordAbbr(String[] abbrDictionary) {
//         abbrDict = new HashMap<>();
//         oriDict = new HashSet<>();
//         for (String word : abbrDictionary) {
//             // add all words into oriDict, if duplicated, skip
//             if (oriDict.contains(word)) {
//                 continue;
//             }
//             oriDict.add(word);
//             // check and put abbreviation into abbrDict
//             String abbr = getAbbr(word);
//             // if already contain the same abbreviation, set unique flag to false
//             if (abbrDict.containsKey(abbr)) {
//                 abbrDict.put(abbr, false);
//             }
//             else {
//                 abbrDict.put(abbr, true);
//             }
//         }
//     }

//     public boolean isUnique(String word) {
//         String abbr = getAbbr(word);
//         if (!abbrDict.containsKey(abbr)) {
//             return true;
//         }
//         // if abbreviation is duplicated, check if it comes from the dictionary
//         else {
//             // check if the abbreviation itself is unique
//            if (oriDict.contains(word)) {
//                return abbrDict.get(abbr);
//            } 
//            return false;
//         }
//     }
    
//     private String getAbbr(String word) {
//         StringBuilder abbr = new StringBuilder();
//         if (word.length() <= 2) {
//             abbr.append(word);
//         }
//         else {
//             abbr.append(word.charAt(0));
//             abbr.append(word.length() - 2);
//             abbr.append(word.charAt(word.length() - 1));
//         }
//         return abbr.toString();
//     }
// }


// // Your ValidWordAbbr object will be instantiated and called as such:
// // ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// // vwa.isUnique("Word");
// // vwa.isUnique("anotherWord");