import java.util.*;

public class CountMiss {
	public static int count(int[] inputs, int capacity) {
		if (capacity <= 0 || inputs.length == 0) {
			return inputs.length;
		}

		LRUCache cache = new LRUCache(capacity);
		for (int input : inputs) {
			cache.get(input);
		}
		return cache.miss;
	}

	private static class LRUCache {
		private int capacity;
		// map store <key, value>
		private LinkedHashMap<Integer, Integer> map;
		public int miss;

		public LRUCache(int cap) {
			capacity = cap;
			miss = 0;
			// the arguments for map are (initialCapacity, loadFactor, accessOrder)
			map = new LinkedHashMap<Integer, Integer>(cap, 0.75f, true) {
				protected boolean removeEldestEntry(Map.Entry eldest) {
					return size() > capacity;
				}
			};
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				++miss;
				map.put(key, key);
				return key;
			}
			else {
				return map.get(key);
			}
		}
	}

	public static void main(String[] args) {
		int[] inputs = {1, 2, 3, 4, 5, 4, 1};
		int capacity = 4;
		System.out.println(CountMiss.count(inputs, capacity));
	}
}



// old version
	// // create LRUCache with double linked-list and hashmap to achieve O(1) access time
	// public static class LRUCache {
	// 	// create class for double linked-list
	// 	public static class ListNode {
	// 		ListNode prev;
	// 		ListNode next;
	// 		int label;

	// 		public ListNode(int label) {
	// 			this.label = label;
	// 			prev = null;
	// 			next = null;
	// 		}
	// 	}

	// 	private ListNode head;
	// 	private ListNode tail;
	// 	private HashMap<Integer, ListNode> map;
	// 	private int capacity;
	// 	public  int miss;

	// 	public LRUCache(int capacity) {
	// 		this.capacity = capacity;
	// 		map = new HashMap<>();
	// 		// setup two dummy nodes
	// 		head = new ListNode(0);
	// 		tail = new ListNode(0);
	// 		head.next = tail;
	// 		tail.prev = head;
	// 		miss = 0;
	// 	}

	// 	public int get(int label) {
	// 		ListNode retrieved;
	// 		if (!map.containsKey(label)) {
	// 			++miss;
	// 			// not in cache, create a new one
	// 			retrieved = new ListNode(label);
	// 			map.put(label, retrieved);
	// 			// if surpass the capacity, evict one
	// 			if (map.size() > capacity) {
	// 				ListNode evicted = evict();
	// 				// remove evicted node from map
	// 				map.remove(evicted.label);
	// 			}
	// 		}
	// 		else {
	// 			retrieved = map.get(label);
	// 			// remove node from list for reordering
	// 			remove(retrieved);
	// 		}
	// 		// put the newNode as head
	// 		setHead(retrieved);
	// 		// System.out.println("current tail label: " + tail.prev.label);
	// 		return retrieved.label;
	// 	}

	// 	// put newHead as head
	// 	public void setHead(ListNode newHead) {
	// 		newHead.next = head.next;
	// 		newHead.prev = head;
	// 		head.next.prev = newHead;
	// 		head.next = newHead;
	// 	}

	// 	private ListNode evict() {
	// 		ListNode evicted = tail.prev;
	// 		// deleted node at tail
	// 		remove(evicted);
	// 		return evicted;
	// 	}

	// 	private void remove(ListNode node) {
	// 		node.prev.next = node.next;
	// 		node.next.prev = node.prev;
	// 	}
	// }
