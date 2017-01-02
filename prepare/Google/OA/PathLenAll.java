import java.util.*;

public class PathLenAll {
	public static int sum(String input) {
		String[] paths = input.trim().split("\n");
		
		Stack<String> stack = new Stack<>();
		// hashset to indicate which levels has found img, avoid duplicate
		HashSet<Integer> foundLevels = new HashSet<>();
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
				// reset found flag if level up
				if (space + 1 < stack.size()) {
					// check whether need to remove
					if (foundLevels.contains(stack.size())) {
						foundLevels.remove(stack.size());
					}
				}
				curLen -= (stack.pop().length() + 1);
			}

			// check if it is image
			if (!foundLevels.contains(space) && (curPath.endsWith(".jpeg") || curPath.endsWith(".gif") || curPath.endsWith(".png"))) {
				sum += curLen;
				foundLevels.add(space);

				// for (String file : stack) {
				// 	System.out.printf("/%s", file);
				// }
				// System.out.printf("/\n");
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
		System.out.println(PathLenAll.sum(test1));
		System.out.println("");

		String test2 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png";
		System.out.println("Input:\n" + test2);
		System.out.println("Output:\n" + PathLenAll.sum(test2));
		System.out.println("");

		String test3 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg";
		System.out.println("Input:\n" + test3);
		System.out.println("Output:\n" + PathLenAll.sum(test3));
		System.out.println("");

		String test4 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg\n   new1.gif\n";
		System.out.println("Input:\n" + test4);
		System.out.println("Output:\n" + PathLenAll.sum(test4));
		System.out.println("");

		String test5 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\nonemore.png\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg\n   new1.gif\nanothermore.png";
		System.out.println("Input:\n" + test5);
		System.out.println("Output:\n" + PathLenAll.sum(test5));
		System.out.println("");

		String test6 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\nonemore.png\ndir1\n dir2\n  dir3\n   what.png\n   dir4\n    new.jpeg\n   new1.gif\nanothermore.png\ndir5\n dir6\n  dir7\n   img1.gif";
		System.out.println("Input:\n" + test6);
		System.out.println("Output:\n" + PathLenAll.sum(test6));
		System.out.println("");
	}
}