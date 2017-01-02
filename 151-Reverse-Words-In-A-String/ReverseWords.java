// Reverse Words in a String Total Accepted: 59321 Total Submissions: 396917 My Submissions Question Solution 
// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.

// click to show clarification.

// Hide Tags String

public class ReverseWords {
    // public String reverseWords(String s) {

    // 	if (s == null || s.length() == 0) {
    // 		return "";
    // 	}
    // 	String sTrim = s.trim();

    //     char[] temp = new char[sTrim.length()];
    //     for (int i = 0, j = 0; i < sTrim.length(); ++i) {
    //     	temp[j] = sTrim.charAt(i);
    //     	++j;
    //     }

    //     reverse(temp, 0, temp.length - 1);
    //     for (int i = 0, j = 0; i < temp.length; ++i) {
    //     	if (temp[i] == ' ') {
    //     		reverse(temp, j, i - 1);
    //     		j = i + 1;
    //     	}
    //     	if (i == temp.length - 1) {
    //     		reverse(temp, j, i);
    //     	}
    //     }

    //     String result = String.valueOf(temp);
    //     return result;
    // }

    // public void reverse(char[] string, int start, int end) {
    // 	char temp;
    // 	for (int i = start, j = end; i < j; ++i, --j) {
    // 		temp = string[i];
    // 		string[i] = string[j];
    // 		string[j] = temp;
    // 	}
    // }

	public String reverseWords(String s) {  
        if (s == null || s.length() == 0) {  
            return "";  
        }  
  
        String[] array = s.split(" ");  
        StringBuilder sb = new StringBuilder();  
        for (int i = array.length - 1; i >= 0; --i) {  
            if (!array[i].equals("")) {  
                sb.append(array[i]).append(" ");  
            }  
        }  
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);  
    } 

    public static void main(String[] args) {
    	ReverseWords A = new ReverseWords();
    	String s = "the sky is blue";
    	// String s = " ";
    	// String s = "   a   ";
    	System.out.println("-" + s + "-" );
    	System.out.println("-" + A.reverseWords(s) + "-");
    }
}