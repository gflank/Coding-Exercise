
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        RemoveElements A = new RemoveElements();
        ListNode head = new ListNode(2);
        ListNode next = new ListNode(1);
        // ListNode next2 = new ListNode(1);
        head.next = next;
        // head.next.next = next2;
        ListNode newHead = A.removeElements(head, 1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
