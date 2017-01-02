
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = head, prev = null, temp = head.next;
        
        while (fast.next != null && fast.next.next != null) {
            // move the fast pointer first
            fast = fast.next.next;
            
            //now move the slow pointer and reverse the first half list
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        ListNode left = slow, right = slow.next;
        // offset for the odd nodes list
        if (fast.next == null) {
            left = prev;
        }
        // finished the reversing when even
        else {
            slow.next = prev;
        }
        
        // compare one by one
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
}
