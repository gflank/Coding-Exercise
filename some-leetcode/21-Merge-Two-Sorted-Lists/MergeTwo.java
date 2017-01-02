// in place version
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }

        // check one by one and link all nodes with l1
        ListNode dum = new ListNode(0);
        dum.next = l1; // dummy node to save the head
        ListNode prev = dum; // previous node when creating the node list
        while (l1 != null && l2 != null) {
            // if value in l2 is larger, insert this node before current l1 node
            if (l2.val < l1.val) {
                ListNode temp = l2.next;
                l2.next = l1;
                prev.next = l2;
                prev = l2;
                l2 = temp;
            }
            else {
                // if value in l1 is larger, don't do anything
                prev = l1;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return dum.next;
    }

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// public class MergeTwo {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null && l2 == null) {
//         	return null;
//         }

//         ListNode dummy = new ListNode(0);
//         ListNode cur = dummy;
//         while (l1 != null && l2 != null) {
//         	if (l1.val <= l2.val) {
//         		cur.next = l1;
//         		l1 = l1.next;
//         	}
//         	else {
//         		cur.next = l2;
//         		l2 = l2.next;
//         	}
//         		cur = cur.next;
//         }
//         if (l1 == null) {
//         	cur.next = l2;
//         }
//         else if (l2 == null) {
//         	cur.next = l1;
//         }

//         return dummy.next;
//     }
// }
