/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode oriHead = head;
        ListNode kAhead = head;
        int len = 0;
        for (int i = 0; i < k; ++i) {
            ++len;
            if (kAhead.next == null) {
                // exactly k nodes
                if (k == len) {
                    return oriHead;
                }
                break;
            }
            kAhead = kAhead.next;
        }
        
        if (k == len) {
            // now go through the list to get k+1th last node
            while (kAhead.next != null) {
                kAhead = kAhead.next;
                head = head.next;
            }
            ListNode newHead = head.next;        
            kAhead.next = oriHead;
            head.next = null;
            return newHead;
        }
        // not enough k nodes
        else {
            return rotateRight(head, k % len);
        }
    }
}