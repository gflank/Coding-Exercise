// Remove Duplicates from Sorted List II Total Accepted: 44634 Total Submissions: 178606 My Submissions Question Solution 
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

// Hide Tags Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        int last;
        while (head.next != null && head.next.next != null) {
        	if (head.next.val == head.next.next.val) {
        		last = head.next.val;
        		head.next = head.next.next.next;
        		while (head.next != null && head.next.val == last) {
        			head.next = head.next.next;
        		}
        	}
        	else {
        		head = head.next;
        	}
        }

        return dummy.next;
    }
}
