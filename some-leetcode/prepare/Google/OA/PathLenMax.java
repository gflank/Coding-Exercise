import java.util.*;

public class PathLenMax {
	public static int maxLen(String input) {
		String[] paths = input.trim().split("\n");
		
		Stack<String> stack = new Stack<>();
		int maxLen = 0, curLen = 0;
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
				// System.out.println("Found an image: " + curLen);
				maxLen = Math.max(maxLen, curLen);
			}

		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println("----------------------------");
		String test1 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\n";
		System.out.println("Input:\n" + test1);
		System.out.println(PathLenMax.maxLen(test1));
		System.out.println("----------------------------");

		System.out.println("----------------------------");
		String test2 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png";
		System.out.println("Input:\n" + test2);
		System.out.println(PathLenMax.maxLen(test2));
		System.out.println("----------------------------");

		System.out.println("----------------------------");
		String test3 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg";
		System.out.println("Input:\n" + test3);
		System.out.println(PathLenMax.maxLen(test3));
		System.out.println("----------------------------");

		System.out.println("----------------------------");
		String test4 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg\nloooooooooooooooooooooong.jpeg";
		System.out.println("Input:\n" + test4);
		System.out.println(PathLenMax.maxLen(test4));
		System.out.println("----------------------------");
	}
}