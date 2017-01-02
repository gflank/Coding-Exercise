// Implement strStr() Total Accepted: 45572 Total Submissions: 206758 My Submissions Question Solution 
// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Update (2014-11-02):
// The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.

// Hide Tags Two Pointers String

public class StringString {
    public int strStr(String haystack, String needle) {

    		if (haystack == null || needle == null) {
    			System.out.println("null");
    			return -1;
    		}
    		if (needle == "") {
    			return 0;
    		}

    		System.out.println(haystack.length());
    		for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
  				for (int j = 0; j < needle.length(); ++j) {
  					if (haystack.charAt(i + j) != needle.charAt(j)) {
  						break;
  					}
  					if (j == needle.length() - 1) {
  						return i;
  					}
  				}
    		}

    		System.out.println("dont find");
    		return -1;
    }

    public static void main (String[] args) {
    	StringString A = new StringString();
    	System.out.println(A.strStr("", ""));
    }
}