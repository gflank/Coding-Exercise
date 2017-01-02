
public class Solution {
    // max heap version
    // public int findKthLargest(int[] nums, int k) {
    //     int len = nums.length;
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, IntComparator);
        
    //     for (int num : nums) {
    //         maxHeap.add(num);
    //     }
        
    //     int result = 0;
    //     for (int i = 0; i < k; ++i) {
    //         result = maxHeap.poll();
    //     }
        
    //     return result;
    // }
    
    // private Comparator<Integer> IntComparator = new Comparator<Integer>() {
    //     public int compare(Integer left, Integer right) {
    //         // let the bigger one be the first
    //         return right - left;
    //     }
    // };
    
    // sort version
    /*
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
    */
    
    /*
    // min heap version
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        heap.add(nums[0]);
        for (int i = 1; i < len; ++i) {
            if (heap.size() < k || nums[i] > heap.peek()) {
                heap.add(nums[i]);                
            }
            
            // make sure there are only the K largest element stored in the heap
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.peek();
    }
    */

    /*
    // partition version
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, k);
    }
    
    // return the Kth largest number
    public int quickSelect(int[] nums, int begin, int end, int k) {
        // shuffle the pivot to avoid worst case
        //int pivotIndex = randInt(begin, end);
        // put the pivot to the end
        //swap(nums, pivotIndex, end);
        int pivot = nums[end];
        int pos = begin - 1;
        for (int i = begin; i < end; ++i) {
            if (nums[i] > pivot) {
                ++pos;
                // System.out.println("num is bigger, swap" + i + pos);
                swap(nums, i, pos);
            }
        }
        System.out.println("here");
        swap(nums, pos + 1, end);
        
        if (pos + 1 == k) {
            return nums[k];
        }
        else if (pos + 1 > k) {
            return quickSelect(nums, begin, pos, k);
        }
        else {
            return quickSelect(nums, pos + 1, end, k - (pos + 1 - begin));
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    */
    
    /*
    public int randInt(int min, int max) {
        Random rand = new Random();
        int result = rand.nextInt(max - min + 1) + min;
        return result;
    }
    */


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len || k <= 0) {
            return 0;
        }
        
        return KLargest(nums, 0, len - 1, k);
    }
    
    private int KLargest(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int pos = start - 1;
        
        for (int i = start; i < end; ++i) {
            // put the larger element to the front
            if (nums[i] > pivot) {
                ++pos;
                swap(nums, pos, i);
            }
        }
        // put the pivot back in middle
        swap(nums, pos + 1, end);
        
        // check the position now
        int pivotPos = pos + 1 - start + 1;
        if (pivotPos == k ) {
            return pivot;
        }
        else if (pivotPos > k) {
            return KLargest(nums, start, pos, k);
        }
        else {
            return KLargest(nums, pos + 2, end, k - pivotPos);
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}

