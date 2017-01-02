// Swap Nodes in Pairs Total Accepted: 53732 Total Submissions: 165596 My Submissions Question Solution 
// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

// Hide Tags Linked List
// Hide Similar Problems (H) Reverse Nodes in k-Group

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode temp1, temp2;
        while (head.next != null && head.next.next != null) {
        	temp1 = head.next; // copy the first node
        	temp2 = head.next.next.next; // copy the third node
        	head.next = head.next.next; // make the second node first node
        	head.next.next = temp1; // make the first node second
        	head.next.next.next = temp2; // reconnect the third node
        	head = head.next.next; // move head forward two
        }

        return dummy.next;
    }
}
