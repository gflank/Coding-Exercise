// Find Peak Element Total Accepted: 22060 Total Submissions: 67702 My Submissions Question Solution 
// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] != num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -oo.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

// click to show spoilers.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Array Binary Search

public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num == null) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            }
            else if (num[mid] < num[mid + 1]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (num[start] > num[end]) {
            return start;
        }
        else {
            return end;
        }

    }

    public static void main(String[] args) {
        FindPeakElement A = new FindPeakElement();
        int[] num = {1, 2, 3, 1};
        System.out.println(A.findPeakElement(num));
    }
}