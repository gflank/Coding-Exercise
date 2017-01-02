// Trapping Rain Water Total Accepted: 39484 Total Submissions: 131625 My Submissions Question Solution 
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

// Hide Tags Array Stack Two Pointers

public class RainWater {
    public int trap(int[] height) {
    	// edge case
    	if (height == null || height.length == 0) {
    		return 0;
    	}

    	int[] max = new int[height.length];
    	int maxTemp = 0;
    	int water = 0;

    	// loop over to gain the left max
    	for (int i = 0; i < height.length; ++i) {
    		max[i] = maxTemp;
    		if (height[i] > maxTemp) {
    			maxTemp = height[i];
    		}
    	}

    	// loop over to gain the right max and also calculate the water amount
    	maxTemp = 0;
    	for (int i = height.length - 1; i >= 0; --i) {
    		max[i] = Math.min(maxTemp, max[i]) - height[i];
    		if (max[i] > 0) {
    			water += max[i];
    		}
    		if (height[i] > maxTemp) {
    			maxTemp = height[i];
    		}
    	}

    	return water;
    }

    public static void main(String[] args) {
    	RainWater A = new RainWater();
    	int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    	System.out.println(A.trap(height));
    }
}
