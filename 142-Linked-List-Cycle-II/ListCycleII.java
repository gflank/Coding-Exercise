// Rewrote version
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // if null or only one node, no loop
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // found loop
            if (slow == fast) {
                break;
            }
        }
        // if no loop, return null
        if (slow != fast) {
            return null;
        }

        // move back the fast pointer and move both pointer at same speed
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}


// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class ListCycleII {
//     // public ListNode detectCycle(ListNode head) {
//     //     if (head == null) {
//     //     	return null;
//     //     }

//     //     int flag = 0;
//     //     ListNode slow = head, fast = head;
//     //     while(fast.next != null && fast.next.next != null) {
//     //     	slow = slow.next;
//     //     	fast = fast.next.next;
//     //     	if (slow == fast) {
//     //     		flag = 1;
//     //     		break;
//     //     	}
//     //     }

//     //     if (flag == 1) {
//     //     	slow = head;
//     //     	while (slow != fast) {
//     //     		slow = slow.next;
//     //     		fast = fast.next;
//     //     	}
//     //     	return slow;
//     //     }
//     //     else {
//     //     	return null;
//     //     }
//     // }

//     public ListNode detectCycle(ListNode head) {
//         if (head == null) {
//             return null;
//         }
        
//         boolean flag = false;
//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if (slow == fast) {
//                 flag = true;
//                 break;
//             }
//         }
        
//         if (!flag) {
//             return null;
//         }
        
//         slow = head;
//         while (true) {
//             if (slow == fast) {
//                 return slow;
//             }
//             slow = slow.next;
//             fast = fast.next;
//         }
//     }
// }
