// concise version
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode newHead = null;
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        ListNode savedHead = head;
        // get the k+1th node
        int count = 0;
        while (head != null && count < k) {
            head = head.next;
            ++count;
        }
        
        if (count == k) {
            ListNode nextHead = reverseKGroup(head, k);
            
            // now reverse the current k nodes
            ListNode prev = nextHead;
            head = savedHead;
            while (count != 0) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
                --count;
            }
            // changed the head to the new one
            savedHead = prev;
        }
        return savedHead;
    }
}

// unneat version
// public class Solution {
//     private ListNode newHead = null;
    
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null || k <= 1) {
//             return head;
//         }
//         ListNode dummy = new ListNode(0);
//         ListNode prevHead = dummy;
//         while (head != null) {
//             ListNode nextNode = reverseK(head, null, 1, k);
//             // if newHead changed, means already k nodes
//             if (newHead != null) {
//                 prevHead.next = newHead;
//                 newHead = null;
//                 prevHead = head;
//                 head.next = null;
//                 head = nextNode;
//             }
//             // if not enough k nodes
//             else {
//                 prevHead.next = head;
//                 break;
//             }
//         }
        
//         return dummy.next;
//     }

//     private ListNode reverseK(ListNode root, ListNode prev, int count, int k) {
//         if (root == null) {
//             return null;
//         }
//         //if reach the kth node
//         if (count == k) {
//             newHead = root;
//             ListNode nextHead = root.next;
//             root.next = prev;
//             return nextHead;
//         }
//         else {
//             ListNode nextHead = reverseK(root.next, root, count + 1, k);
//             // if no enough nodes, return null
//             if (newHead == null) {
//                 return null;
//             }
//             else {
//                 root.next = prev;
//                 return nextHead;
//             }
//         }
//     }
// }