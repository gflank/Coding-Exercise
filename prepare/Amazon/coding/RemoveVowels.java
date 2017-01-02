import java.util.*;

public class RemoveVowels {
	public static String removeVowels(String s, String v) {
		String sLow = s.toLowerCase();
		String vLow = v.toLowerCase();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < sLow.length(); ++i) {
			// if not vowel
			if (vLow.indexOf(s.charAt(i)) == -1) {
				res.append(s.charAt(i));
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String v = "aoEUi";
		String s = "Hey there, who are you?";
		System.out.println(RemoveVowels.removeVowels(s, v));
	}
}