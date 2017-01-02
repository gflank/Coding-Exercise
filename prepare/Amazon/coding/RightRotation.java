import java.util.*;

public class RightRotation {
	public static int rightRotation(String word1, String word2) {
		if (word1.length() == 0 || word2.length() == 0 || word1.length() != word2.length()) {
			return -1;
		}

		String template = word1 + word1;
		if (template.indexOf(word2) == -1) {
			return -1;
		}
		return 1;
	}

	public static void main(String[] args) {
		String word1 = "abcd";
		String word2 = "dabc";
		System.out.println(RightRotation.rightRotation(word1, word2));
	}
}