// Merge Sorted Array Total Accepted: 48346 Total Submissions: 160294 My Submissions Question Solution 
// Given two sorted integer arrays A and B, merge B into A as one sorted array.

// Note:
// You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

// Hide Tags Array Two Pointers

// public class MergeSortedArray {
//     public void merge(int A[], int m, int B[], int n) {
//         int execute = 0;
//         if (m == 0 && n == 0) {
//         	execute = 1;
//         }
//         else if (m == 0) {
//         	for (int i = 0; i < n; ++i) {
//         		A[i] = B[i];
//         	}
//         	execute = 1;
//         }
//         else if (n == 0) {
//         	execute = 1;
//         }

//         if (execute == 0) {
//         	int[] C = new int[m + n];
//         	int APoint = 0;
//         	int BPoint = 0;
//         	int CPoint = 0;
//         	while (true) {
//         		if (A[APoint] <= B[BPoint]) {
//         			C[CPoint] = A[APoint];
//         			++APoint;
//         		}
//         		else {
//         			C[CPoint] = B[BPoint];
//         			++BPoint;
//         		}
//     			++CPoint;

//     			if (CPoint == m + n) {
//     				break;
//     			}
//     			if (APoint == m) {
//     				while (CPoint < m + n) {
//     					C[CPoint] = B[BPoint];
//     					++CPoint;
//     					++BPoint;
//     				}
//     				break;
//     			}
//     			if (BPoint == n) {
//     				while (CPoint < m + n) {
//     					C[CPoint] = A[APoint];
//     					++CPoint;
//     					++APoint;
//     				}
//     				break;
//     			}
    			
//         	}

//         	for (int i = 0; i < m + n; ++i) {
//         		A[i] = C[i];
//         	}
//         }
//     }

//     public static void main(String[] args) {
//     	MergeSortedArray Solution = new MergeSortedArray();
//     	int[] A = {1, 3, 5, 7, 0, 0, 0, 0};
//     	int[] B = {2, 10,11, 18};
//     	Solution.merge(A, 4, B, B.length);
//     	for (int i : A) {
//     		System.out.println(i);
//     	}
//     }
// }

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        
        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[cur] = nums1[p1];
                --p1;
            }
            else {
                nums1[cur] = nums2[p2];
                --p2;
            }
            --cur;
        }
        while (p2 >= 0) {
            nums1[cur] = nums2[p2];
            --cur;
            --p2;
        }
    }
}
