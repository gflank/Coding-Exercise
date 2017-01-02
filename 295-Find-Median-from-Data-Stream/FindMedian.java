import java.util.*;

class FindMedian {
    private Queue<Integer> smallHalf = new PriorityQueue<Integer>();
    private Queue<Integer> largeHalf = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        smallHalf.offer(num);
        largeHalf.offer(smallHalf.poll());
        
        if (smallHalf.size() < largeHalf.size() - 1) {
            smallHalf.offer(largeHalf.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int lenS = smallHalf.size();
        int lenL = largeHalf.size();
        if (lenS == lenL) {
            return ((double)(smallHalf.peek()) + (double)(largeHalf.peek())) / 2;
        }
        else if (lenS > lenL) {
            return (double)(smallHalf.peek());
        }
        else {
            return (double)(largeHalf.peek());
        }
    }

    public static void main(String args[]) {
    	FindMedian test = new FindMedian();
    	test.addNum(-1);
    	System.out.println(test.findMedian());
    	test.addNum(-2);
    	System.out.println(test.findMedian());
    	test.addNum(-3);
    	System.out.println(test.findMedian());
    	test.addNum(-4);
    	System.out.println(test.findMedian());
    	test.addNum(-5);
    	System.out.println(test.findMedian());
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
