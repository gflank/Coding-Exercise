import java.util.*;

public class LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}

		String res = s.substring(0, 1);
		for (int i = 1; i < s.length(); ++i) {
			// try to extend the palindrome by two positions
			if (valid(s, i - res.length() - 1, i)) {
				res = s.substring(i - res.length() - 1, i + 1);
			}
			// try to extend the palindrome by one positions
			else if (valid(s, i - res.length(), i)) {
				res = s.substring(i - res.length(), i + 1);
			}
		}
		return res;
	}

	private boolean valid(String s, int start, int end) {
		if (start < 0 || end >= s.length()) {
			return false;
		}
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			++start;
			--end;
		}
		return true;
	}

	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.longestPalindrome("aaaabaaa"));
	}
}