
public class Solution {
	// TLE version
    // public int maxArea(int[] height) {
    //     int len = height.length;
    //     if (len <= 1) {
    //         return 0;
    //     }
        
    //     // set two index on two sides
    //     int left = 0, right = len - 1;
    //     int max = 0;
        
    //     while (left < right) {
    //         // choose the bigger one to be the max area
    //         int area = (right - left) * Math.min(height[left], height[right]);
    //         max = Math.max(max, area);
    //         // store the last height and swift position
    //         int leftNext = left, rightNext = right;
    //         boolean leftNotFound = false, rightNotFound = false;
    //         // find the next higher height from left
    //         while (leftNext < right && height[leftNext] <= height[left]) {
    //             ++leftNext;
    //         }
    //         if (leftNext >= right) {
    //             leftNotFound = true;
    //         }
    //         // find the next higher one from right
    //         while (rightNext >= left && height[rightNext] <= height[right]) {
    //             --rightNext;
    //         }
    //         if (rightNext <= left) {
    //             rightNotFound = true;
    //         }
    //         // break earlier for not wasting time
    //         if (leftNotFound && rightNotFound) {
    //             break;
    //         }
    //         // swift index according to the area they form
    //         int areaLeft = 0, areaRight = 0;
    //         if (!leftNotFound) {
    //             areaLeft = (right - leftNext) * Math.min(height[right], height[leftNext]);
    //         }
    //         if (!rightNotFound) {
    //             areaRight = (rightNext - left) * Math.min(height[rightNext], height[left]);
    //         }
    //         if (areaLeft > areaRight) {
    //             left = leftNext;
    //         }
    //         else if (areaLeft < areaRight) {
    //             right = rightNext;
    //         }
    //         else {
    //             if (height[leftNext] >= height[rightNext]) {
    //                 left = leftNext;
    //             }
    //             else {
    //                 right = rightNext;
    //             }
    //         }
            
    //     }
        
    //     return max;
    // }

	// O(n) solution with simple condition
    public int maxArea(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }

        int left = 0, right = len - 1, max = 0;
        
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            
            if (height[left] < height[right]) {
                ++left;
            }
            else if (height[left] > height[right]) {
                --right;
            }
            else {
                ++left;
                --right;
            }
        }
        
        return max;
    }
}
