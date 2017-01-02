import java.util.*;

public class MergeKLists {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	// divide and conquer version
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return helper(lists, 0, lists.length - 1);
	}

	private ListNode helper(ListNode[] lists, int start, int end) {
		int k = lists.length;
		if (start == end) {
			return lists[start];
		}

		int half = start + (end - start) / 2;
		return mergeTwoLists(helper(lists, start, half), helper(lists, half + 1, end));
	}

	private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
		if (n1 == null) {
			return n2;
		}
		else if (n2 == null) {
			return n1;
		}

		ListNode dum = new ListNode(0);
		dum.next = n1;
		ListNode prev = dum;
		while (n1 != null && n2 != null) {
			if (n1.val <= n2.val) {
				prev = n1;
				n1 = n1.next;
			}
			// now insert n2 in front of n1
			else {
				ListNode temp = n2.next;
				n2.next = n1;
				prev.next = n2;
				prev = n2;
				n2 = temp;
			}
		}
		// check if n1 is null
		if (n1 == null) {
			// connect n1's tail to current n2
			prev.next = n2;
		}
		return dum.next;
	}

	// heap version
	// public ListNode mergeKLists(ListNode[] lists) {
	// 	if (lists.length == 0) {
	// 		return null;
	// 	}

	// 	// create a min heap
	// 	// PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
	// 	PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
	// 		public int compare(ListNode n1, ListNode n2) {
	// 			return n1.val - n2.val;
	// 		}
	// 	});
	// 	// put the first k head nodes into heap
	// 	for (ListNode cur : lists) {
	// 		// take care of the null lists
	// 		if (cur != null) {
	// 			heap.offer(cur);
	// 		}
	// 	}
	// 	ListNode dum = new ListNode(0);
	// 	ListNode prev = dum;
	// 	while (!heap.isEmpty()) {
	// 		// get the min node from the heap
	// 		ListNode cur = heap.poll();
	// 		if (cur.next != null) {
	// 			heap.offer(cur.next);
	// 		}
	// 		// link the polled node
	// 		prev.next = cur;
	// 		prev = cur;
	// 	}
	// 	return dum.next;
	// }
}