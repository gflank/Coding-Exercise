// Linked List Cycle Total Accepted: 65319 Total Submissions: 179841 My Submissions Question Solution 
// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?

// Hide Tags Linked List Two Pointers
// Hide Similar Problems (M) Linked List Cycle II

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
        	return false;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		return true;
        	}
        }

        return false;
    }
}
