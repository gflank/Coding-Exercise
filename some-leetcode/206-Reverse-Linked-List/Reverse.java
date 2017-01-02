// Reverse Linked List Total Accepted: 25121 Total Submissions: 79533 My Submissions Question Solution 
// Reverse a singly linked list.

// click to show more hints.

// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

// Hide Tags Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode prev = null;
        ListNode temp;
        while (head != null) {
        	temp = head.next;
        	head.next = prev;
        	prev = head;
        	head = temp;
        }

        return prev;
    }
}

// recursion version
// public class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
        
//         return helper(head, null);
//     }
    
//     private ListNode helper(ListNode head, ListNode prev) {
//         if (head == null) {
//             return prev;
//         }
        
//         ListNode temp = head.next;
//         head.next = prev;
//         return helper(temp, head);
//     }
// }
