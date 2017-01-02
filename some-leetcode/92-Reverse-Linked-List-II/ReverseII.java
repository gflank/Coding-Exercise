// Reverse Linked List II Total Accepted: 43371 Total Submissions: 166560 My Submissions Question Solution 
// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

// Hide Tags Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
        	return head;
        }
        if (m == n) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        // head is the dummy 0'th node now

        for (int i = 1; i < m; ++i) {
        	head = head.next;
        }
        // head is the m-1'th node now
        ListNode mPrev = head;
        head = head.next;
        // head is the m'th node now
        ListNode mNode = head;

        ListNode prev = null;
        ListNode temp;
        for (int i = 0; i <= n - m; ++i) {
        	temp = head.next;
        	head.next = prev;
        	prev = head;
        	head = temp;
        }
        // head is the n+1'th node now

        mPrev.next = prev;
        mNode.next = head;

        return dummy.next;
    }
}
