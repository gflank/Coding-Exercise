
public class Shortest {
    public String shortestPalindrome(String s) {
        StringBuilder rs = new StringBuilder(s).reverse();
        for (int i = 0; i < s.length(); ++i) {
        	if (s.startsWith(rs.substring(i))) {
        		return rs.substring(0, i) + s;
        	}
        }

        return s;
    }
}
