import java.util.*;

public class RemoveWhite {
	public String remove(String input) {
		if (input.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) != ' ') {
				sb.append(input.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveWhite test = new RemoveWhite();
		System.out.println(test.remove("  who   are  you ? "));
	}
}
