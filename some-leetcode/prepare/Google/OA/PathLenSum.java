import java.util.*;

public class PathLenSum {
	public static int sum(String input) {
		String[] paths = input.trim().split("\n");
		
		Stack<String> stack = new Stack<>();
		int sum = 0, curLen = 0;
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
				curLen -= (stack.pop().length() + 1);
			}
			// append current path len
			curLen += curPath.length() - space + 1;
			stack.push(curPath.trim());

			// check if it is image
			if (curPath.endsWith(".jpeg") || curPath.endsWith(".gif") || curPath.endsWith(".png")) {
				sum += curLen;

				for (String file : stack) {
					System.out.printf("/%s", file);
				}
				System.out.printf("\n");
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		String test1 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\n";
		System.out.println("Input:\n" + test1);
		System.out.println(PathLenSum.sum(test1));

		String test2 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png";
		System.out.println("Input:\n" + test2);
		System.out.println(PathLenSum.sum(test2));

		String test3 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg";
		System.out.println("Input:\n" + test3);
		System.out.println(PathLenSum.sum(test3));
	}
}