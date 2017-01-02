
public class RegularMatch {
    public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1) {
			if (s.length() != 1) {
				return false;
			}
			if (p.charAt(0) == '*') {
				return false;
			}

			if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
				return true;
			}

			return false;
		}

		if (p.charAt(1) != '*') {
			if (s.length() == 0) {
				return false;
			}

			if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
				return isMatch(s.substring(1), p.substring(1));
			}
			else {
				return false;
			}
		}
		else {
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				++i;
			}
			return false;
		}
    }
}
