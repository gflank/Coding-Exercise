import java.util.*;
import java.io.*;

/* thoughts:
	1. Should consider only the left most valid symbol // or /*
	2. When /* appear, should only consider * / after
	3. space between / and / or * is invalid
	4. indicator surrounded by "" is invalid
	5. assume the input code is valid
*/

public class IdenCom {
	public static List<String> iden(List<String> codes) {
		List<String> res = new ArrayList<>();
		if (codes.size() == 0) return res;

		boolean started = false;
		for (String line : codes) {
			started = scanAndAdd(line, res, started);
		}
		return res;
	}

	private static boolean scanAndAdd(String line, List<String> res, boolean started) {
		if (line.length() <= 1) {
			if (started) res.add(line);
			return started;
		}

		// now scan through this line for comment
		int startPos = 0;
		boolean quote = false;
		char quoteType = '?';
		for (int i = 1; i < line.length(); ++i) {
			if (!started) {
				// check for the start of comment
				if (!quote) {
					if (line.charAt(i - 1) == '/' && line.charAt(i) == '/') {
						// if // appears
						res.add(line.substring(i - 1, line.length()));
						return false;
					}
					else if (line.charAt(i - 1) == '/' && line.charAt(i) == '*') {
						// if /* appears
						startPos = i - 1;
						started = true;
					}
					else if (line.charAt(i - 1) == '"' || line.charAt(i - 1) == '\'') {
						// if ' or " appears
						quote = true;
						quoteType = line.charAt(i - 1);
					}
				}
				// need to skip the quote
				else {
					if (line.charAt(i - 1) == quoteType) {
						quote = false;
					}
				}
			}
			else {
				// now check for the end of comment
				if (line.charAt(i - 1) == '*' && line.charAt(i) == '/') {
					res.add(line.substring(startPos, i + 1));
					started = false;
				}
			}
		}
		if (started) res.add(line.substring(startPos, line.length()));
		return started;
	}

	public static void main(String[] args) {
		try {
			File file = new File("test1.java");
			Scanner scanner = new Scanner(file);
			List<String> codes = new ArrayList<>();
			while (scanner.hasNextLine()) {
				codes.add(scanner.nextLine());
			}

			List<String> res = IdenCom.iden(codes);
			for (String cur : res) {
				System.out.println(cur);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();

		try {
			File file = new File("test2.cpp");
			Scanner scanner = new Scanner(file);
			List<String> codes = new ArrayList<>();
			while (scanner.hasNextLine()) {
				codes.add(scanner.nextLine());
			}

			List<String> res = IdenCom.iden(codes);
			for (String cur : res) {
				System.out.println(cur);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}