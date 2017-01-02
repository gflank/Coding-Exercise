// Reorder List Total Accepted: 43803 Total Submissions: 208841 My Submissions Question Solution 
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

// Hide Tags Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) {
    		return;
    	}

    	ListNode mid = findMid(head);
    	ListNode right = reverse(mid.next);
    	mid.next = null;
		merge(head, right);
    }

    private ListNode reverse(ListNode head) {
    	ListNode temp;
    	ListNode last = null;
    	while (head != null) {
    		temp = head.next;
    		head.next = last;
    		last = head;
    		head = temp;
    	}
    	return last;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
    	ListNode dummy = new ListNode(0);
    	ListNode cur = dummy;
    	while (head1 != null || head2 != null) {
    		if (head1 != null) {
    			cur.next = head1;
    			cur = cur.next;
    			head1 = head1.next;
    		}
    		if (head2 != null) {
    			cur.next = head2;
    			cur = cur.next;
    			head2 = head2.next;
    		}
    	}
    	return dummy.next;
    }

    private ListNode findMid(ListNode head) {
    	ListNode slow = head, fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
}
