/* 
input range [1, 10,000,000]
554336611 -> 55436611
554332211 -> 55433221
554662211 -> 55466221
554332110 -> 55433210

methodology: remove the former when ascending order occured if it is duplicated
*/
public class DeleteOneDup {
	public static int deleteOne(int num) {
		// out of bound detection
		if (num < 10 || num > 1000000000) {
			return -1;
		}

		StringBuilder input = new StringBuilder("" + num);
		int dupIndex = -1; // index to mark which bit to delete
		boolean duplicated = false; // indicate whether previous bit is duplicated
		char prevChar = '*';
		for (int i = 0; i < input.length(); ++i) {
			char curChar = input.charAt(i);
			// if ascending, break
			if (duplicated && curChar - prevChar > 0) {
				break;
			}

			if (prevChar == curChar) {
				dupIndex = i;
				duplicated = true;
			}
			else {
				duplicated = false;
				prevChar = curChar;
			}
		}

		// if no duplicate, return invalid
		if (dupIndex == -1) {
			return -1;
		}
		// convert string to int
		return Integer.parseInt(input.deleteCharAt(dupIndex).toString());
	}

	public static void main(String[] args) {
		int test1 = 0;
		int test2 = 1000000000;
		int test3 = -10000;
		int test4 = 554336611;
		int test5 = 554332211;
		int test6 = 554662211;
		int test7 = 554332110;
		int test8 = 123456;
		int test9 = 76473124;

		System.out.println(test1 + " -> " + DeleteOneDup.deleteOne(test1));
		System.out.println(test2 + " -> " + DeleteOneDup.deleteOne(test2));
		System.out.println(test3 + " -> " + DeleteOneDup.deleteOne(test3));
		System.out.println(test4 + " -> " + DeleteOneDup.deleteOne(test4));
		System.out.println(test5 + " -> " + DeleteOneDup.deleteOne(test5));
		System.out.println(test6 + " -> " + DeleteOneDup.deleteOne(test6));
		System.out.println(test7 + " -> " + DeleteOneDup.deleteOne(test7));
		System.out.println(test8 + " -> " + DeleteOneDup.deleteOne(test8));
		System.out.println(test9 + " -> " + DeleteOneDup.deleteOne(test9));
	}
}