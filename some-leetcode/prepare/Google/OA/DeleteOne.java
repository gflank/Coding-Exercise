/* 
input range [1, 10,000,000]
1234 -> 234, 134, 124, 123 -> return 234
1000 -> 000, 100 -> return 100
9378 -> 378, 978, 938, 937 -> return 978

methodology: loop from the left, once current number is smaller than the next one (or is the last number), delete it
*/
public class DeleteOne {
	public static int deleteOne(int num) {
		// out of bound detection
		if (num < 10 || num > 10000000) {
			return -1;
		}

		StringBuilder res = new StringBuilder();
		String numS = "" + num;
		boolean deleted = false;
		for (int i = 0; i < numS.length() - 1; ++i) {
			if (!deleted && numS.charAt(i) - numS.charAt(i + 1) <= 0) {
				deleted = true;
			}
			else {
				res.append(numS.charAt(i));
			}
		}
		if (deleted) {
			res.append(numS.charAt(numS.length() - 1));
		}
		return Integer.parseInt(res.toString());
	}

	public static void main(String[] args) {
		int test1 = 1234;
		int test2 = 1000;
		int test3 = 9378;
		int test4 = 0;
		int test5 = 1000000000;
		int test6 = -10000;
		int test7 = 2222;
		int test8 = 4321;
		int test9 = 8478;
		int test10 = 1;
		int test11 = 10;

		System.out.println(test1 + " -> " + DeleteOne.deleteOne(test1));
		System.out.println(test2 + " -> " + DeleteOne.deleteOne(test2));
		System.out.println(test3 + " -> " + DeleteOne.deleteOne(test3));
		System.out.println(test4 + " -> " + DeleteOne.deleteOne(test4));
		System.out.println(test5 + " -> " + DeleteOne.deleteOne(test5));
		System.out.println(test6 + " -> " + DeleteOne.deleteOne(test6));
		System.out.println(test7 + " -> " + DeleteOne.deleteOne(test7));
		System.out.println(test8 + " -> " + DeleteOne.deleteOne(test8));
		System.out.println(test9 + " -> " + DeleteOne.deleteOne(test9));
		System.out.println(test10 + " -> " + DeleteOne.deleteOne(test10));
		System.out.println(test11 + " -> " + DeleteOne.deleteOne(test11));
	}
}