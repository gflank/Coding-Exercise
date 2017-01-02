// rewrote neat version
public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // create a min heap
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // put the first k head nodes into heap
        for (ListNode cur : lists) {
            // take care of the null lists
            if (cur != null) {
                heap.offer(cur);
            }
        }
        ListNode dum = new ListNode(0);
        ListNode prev = dum;
        while (!heap.isEmpty()) {
            // get the min node from the heap
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.offer(cur.next);
            }
            // link the polled node
            prev.next = cur;
            prev = cur;
        }
        return dum.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeK {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
        	return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; ++i) {
        	if (lists[i] != null) {
	        	minHeap.add(lists[i]);
        	}
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
        	cur.next = minHeap.poll();
        	cur = cur.next;
        	if (cur.next != null) {
        		minHeap.add(cur.next);
        	}
        }

        return dummy.next;
    }

    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
    	public int compare(ListNode left, ListNode right) {
    		if (left == null) {
    			return 1;
    		}
    		else if (right == null) {
    			return -1;
    		}
    		return left.val - right.val;
    	}
    };
}

// recursion version
public class MergeK {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
        	return null;
        }

        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
    	if (start == end) {
    		return lists[start];
    	}

    	int mid = start + (end - start) / 2;
    	ListNode left = mergeHelper(lists, start, mid);
    	ListNode right = mergeHelper(lists, mid + 1, end);

    	return mergeTwo(left, right);
    }

    private ListNode mergeTwo(ListNode left, ListNode right) {
    	ListNode dummy = new ListNode(0);
    	ListNode cur = dummy;
    	while (left != null && right != null) {
    		if (left.val <= right.val) {
    			cur.next = left;
    			left = left.next;
    		}
    		else {
    			cur.next = right;
    			right = right.next;
    		}
    		cur = cur.next;
    	}
    	if (left != null) {
    		cur.next = left;
    	}
    	if (right != null) {
    		cur.next = right;
    	}

    	return dummy.next;
    }
}
