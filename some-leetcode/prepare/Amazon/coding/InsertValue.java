import java.util.*;

public class InsertValue {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	// rewrote version
	public static ListNode insert(ListNode cur, int insert) {
		ListNode insertNode = new ListNode(insert);
		if (cur == null) {
			// return the new node only
			insertNode.next = insertNode;
			return insertNode;
		}

		// record the origin node to avoid infinitely loop
		ListNode origin = cur;
		while (true) {
			// two cases to trigger insert operation
			// normal situation
			if (cur.val < insert && cur.next.val >= insert) {
				break;
			}
			// insert value larger than max or smaller than min
			else if (cur.val > cur.next.val && (insert >= cur.val || insert <= cur.next.val)) {
				break;
			}
			cur = cur.next;

			// if loop once without discovering insert position, the all same case, could insert anywhere
			if (cur == origin) {
				break;
			}
		}

		// put the new node between cur and cur.next
		insertNode.next = cur.next;
		cur.next = insertNode;
		return insertNode;
	}

	// long version
	// public static ListNode insert(ListNode cur, int insert) {
	// 	ListNode insertNode = new ListNode(insert);
	// 	if (cur == null) {
	// 		insertNode.next = insertNode;
	// 		return insertNode;
	// 	}
	// 	// if only one node
	// 	if (cur.next == cur) {
	// 		cur.next = insertNode;
	// 		insertNode.next = cur;
	// 		return insertNode;
	// 	}

	// 	// first gain the min and max nodes
	// 	// also save the original node to avoid the case all numbers are the same
	// 	ListNode prev = cur, ori = cur, min, max;
	// 	cur = cur.next;
	// 	while (cur.val >= prev.val) {
	// 		// if loop through once without discovering min or max, the all same case
	// 		if (cur == ori) {
	// 			// insert between cur and prev
	// 			prev.next = insertNode;
	// 			insertNode.next = cur;
	// 			return insertNode;
	// 		}
	// 		prev = cur;
	// 		cur = cur.next;
	// 	}
	// 	// discovered the min and max
	// 	min = cur;
	// 	max = prev;

	// 	// check edge case, insert > max or insert < min, put between min and max
	// 	if (insert <= min.val || insert >= max.val) {
	// 		max.next = insertNode;
	// 		insertNode.next = min;
	// 		return insertNode;
	// 	}

	// 	// loop again to find correct position to insert
	// 	prev = min;
	// 	cur = min.next;
	// 	while (insert > cur.val) {
	// 		prev = cur;
	// 		cur = cur.next;
	// 	}
	// 	// now insert the new node before cur node
	// 	prev.next = insertNode;
	// 	insertNode.next = cur;
	// 	return insertNode;
	// }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;

		ListNode cur = InsertValue.insert(n6, 4);
		for (int i = 0; i < 9; ++i) {
			System.out.printf("%d ", cur.val);
			cur = cur.next;
		}
		System.out.println("");

		/*----------------------------------*/

		ListNode n11 = new ListNode(2);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(2);
		n11.next = n12;
		n12.next = n13;
		n13.next = n11;

		cur = InsertValue.insert(n12, 2);
		for (int i = 0; i < 5; ++i) {
			System.out.printf("%d ", cur.val);
			cur = cur.next;
		}
		System.out.println("");

	}
}