// Easy Rotate String

// 20% Accepted
// Given a string and an offset, rotate string by offset. (rotate from left to right)

// Example
// Given "abcdefg"

// for offset=0, return "abcdefg"

// for offset=1, return "gabcdef"

// for offset=2, return "fgabcde"

// for offset=3, return "efgabcd"

// ...


// Tags Expand 
// String

public class RotateString {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
		if (A == null || A.length == 0) {
    		return A;
    	}

    	offset = offset % A.length;
    	offset = A.length - offset;

    	reverse(A, 0, offset - 1);
    	reverse(A, offset, A.length - 1);
    	reverse(A, 0 , A.length - 1);
        return A;
    }

    public void reverse(char[] string, int start, int end) {
    	char temp;
    	for (int i = start, j = end; i < j; ++i, --j) {
    		temp = string[i];
    		string[i] = string[j];
    		string[j] = temp;
    	}
    }

    public static void main(String[] args) {
        RotateString A = new RotateString();
        // int[] nums = {1, 2, 3, 4, 5, 6, 7};
        char[] string = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        for (char i : string) {
	        System.out.println(i);
        }
        A.rotateString(string, 3);
        for (char i : string) {
            System.out.println(i);
        }
    }
}