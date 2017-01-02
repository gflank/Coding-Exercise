import java.util.*;

public class FindLoop {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public static ListNode findLoop(ListNode head) {
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

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		ListNode res = FindLoop.findLoop(node1);
		if (res == null) {
			System.out.println("No loop");
		}
		else {
			System.out.println("Loop start from: " + res.val);
		}
	}
}