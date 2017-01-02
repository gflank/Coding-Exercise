import java.util.*;

public class ReverseHalf {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public void reverseHalf(ListNode root) {
		if (root == null || root.next == null) {
			return;
		}

		// defined slow and fast nodes to locate the middle node
		ListNode fast = root, slow = root, prevTail = root;
		while (fast != null && fast.next != null) {
			prevTail = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// now starting to reverse the remain nodes
		ListNode prev = null;
		while (slow != null) {
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		// do not forget to connect the former half with the latter half
		prevTail.next = prev;
	}

	public static void main(String[] args) {
		ReverseHalf test = new ReverseHalf();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		printList(node1);
		System.out.println("-------------------");
		test.reverseHalf(node1);
		printList(node1);
	}

	public static void printList(ListNode root) {
		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}
}