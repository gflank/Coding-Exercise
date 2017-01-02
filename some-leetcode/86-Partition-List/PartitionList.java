
public class PartitionList {
	// workable version but Memory Limit Exceeded
   //  public ListNode partition(ListNode head, int x) {
   //  	if (head == null) {
   //  		return null;
   //  	}

   //  	ListNode lessHead = new ListNode(0);
   //  	ListNode greaterHead = new ListNode(0);
   //  	ListNode greaterCur = greaterHead;
   //  	lessHead.next = head;
   //  	ListNode last = lessHead;

   //  	while (true) {
   //  		if (head.val >= x) {
   //  			// put the new greater node after the new list
   //  			greaterCur.next = head;
   //  			greaterCur = greaterCur.next;
   //  			// disconnect the original node
   //  			if (head.next != null) {
   //  				last.next = head.next;
   //  			}
   //  		}
   //  		// if the node is removed for original list, the last should not be changed
   //  		else {
   //  			last = head;
   //  		}
   //  		if (head.next == null) {
   //  			break;
   //  		}
			// head = head.next;
   //  	}

   //  	// add a null node to the end of the new list
   //  	greaterCur.next = null;
   //  	// connect two lists
   //  	head.next = greaterHead.next;

   //  	return lessHead.next;
   //  }

    public ListNode partition(ListNode head, int x) {
    	if (head == null) {
    		return null;
    	}

    	ListNode leftDummy = new ListNode(0);
    	ListNode rightDummy = new ListNode(0);
    	ListNode left = leftDummy, right = rightDummy;

    	while (head != null) {
    		if (head.val < x) {
    			left.next = head;
    			left = left.next;
    		}
    		else {
    			right.next = head;
    			right = right.next;
    		}

    		head = head.next;
    	}

    	right.next = null;
    	left.next = rightDummy.next;
    	return leftDummy.next;
    }
}
