public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }
        if (buildings[0].length == 0) {
            return res;
        }
        
        List<int[]> inputs = new ArrayList<>();
        for (int i = 0; i < buildings.length; ++i) {
            inputs.add(new int[] {buildings[i][0], -buildings[i][2]});
            inputs.add(new int[] {buildings[i][1], buildings[i][2]});
        }
        // sort the buildings from left to right, highest to lowest, begin to end
        // ascending order
        Collections.sort(inputs, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        // define a max heap to maintain current view's highest height
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        int prev = 0;
        // 0 as initial height
        heap.offer(prev);
        for (int[] input : inputs) {
            // if building begin, add to heap (add O(log n))
            if (input[1] < 0) {
                heap.offer(-input[1]);
            }
            // if building end, remove from heap (find O(n) + remove O(log n))
            else {
                heap.remove(input[1]);
            }
            
            // peek the top everytime, if height changed, add to result
            int top = heap.peek();
            if (top != prev) {
                prev = top;
                res.add(new int[] {input[0], top});
            }
        }
        
        return res;
    }
}