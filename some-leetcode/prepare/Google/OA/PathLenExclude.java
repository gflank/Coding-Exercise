import java.util.*;

public class PathLenExclude {
	public static int sum(String input) {
		String[] paths = input.trim().split("\n");
		
		Stack<String> stack = new Stack<>();
		int sum = 0, curLen = 0;
		boolean found = false; // whether found in current or previous level
		for (String curPath : paths) {
			// count the spaces ahead
			int space = 0;
			for (int i = 0; i < curPath.length(); ++i) {
				if (curPath.charAt(i) == ' ') {
					++space;
				}
				else {
					break;
				}
			}

			// for same level or level up (do not need to pop if level down)
			// pop out all content including the same level
			while (space < stack.size()) {
				// reset found flag if level up
				if (space + 1 < stack.size()) {
					found = false;
				}
				curLen -= (stack.pop().length() + 1);
			}

			// check if it is image
			if (!found && (curPath.endsWith(".jpeg") || curPath.endsWith(".gif") || curPath.endsWith(".png"))) {
				sum += curLen + 1; // +1 for slash
				found = true;

				for (String file : stack) {
					System.out.printf("/%s", file);
				}
				System.out.printf("\n");
			}

			// append current path len
			curLen += curPath.length() - space + 1;
			stack.push(curPath.trim());
		}
		return sum;
	}

	public static void main(String[] args) {
		String test1 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\n";
		System.out.println("Input:\n" + test1);
		System.out.println(PathLenExclude.sum(test1));
		System.out.println("");

		String test2 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png";
		System.out.println("Input:\n" + test2);
		System.out.println(PathLenExclude.sum(test2));
		System.out.println("");

		String test3 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg";
		System.out.println("Input:\n" + test3);
		System.out.println(PathLenExclude.sum(test3));
		System.out.println("");
	}
}