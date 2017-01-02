// Sort List Total Accepted: 45964 Total Submissions: 208835 My Submissions Question Solution 
// Sort a linked list in O(n log n) time using constant space complexity.

// Hide Tags Linked List Sort

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
    	ListNode dummy = new ListNode(0);
    	ListNode head = dummy;
    	while (head1 != null && head2 != null) {
    		if (head1.val <= head2.val) {
    			head.next = head1;
    			head1 = head1.next;
    		}
    		else {
    			head.next = head2;
    			head2 = head2.next;
    		}
    		head = head.next;
    	}
    	if (head1 != null) {
    		head.next = head1;
    	}
    	else {
    		head.next = head2;
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
