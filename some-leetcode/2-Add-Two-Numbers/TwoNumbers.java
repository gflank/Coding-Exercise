// Add Two Numbers Total Accepted: 70562 Total Submissions: 336579 My Submissions Question Solution 
// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

// Hide Tags Linked List Math

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class TwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }

        int carry = 0;
        int sum;
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while (l1 != null || l2 != null || carry == 1) {
        	sum = 0;
        	if (l1 != null) {
        		sum += l1.val;
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		sum += l2.val;
        		l2 = l2.next;
        	}
        	sum += carry;
        	if (sum >= 10) {
        		carry = 1;
        		sum = sum % 10;
        	}
        	else {
        		carry = 0;
        	}

        	ListNode node = new ListNode(sum);
        	curNode.next = node;
        	curNode = curNode.next;
        }

        return dummy.next;
    }
}
