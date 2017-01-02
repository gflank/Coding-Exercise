// rewrote version, changed condition to pass all tests
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; ++i) {
            int cur;
            if (i != heights.length) {
                cur = heights[i];
            }
            else {
                cur = -1;
            }
            
            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w;
                if (stack.isEmpty()) {
                    w = i;
                }
                else {
                    w = i - 1 - stack.peek();
                }
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}

// import java.util.*;

// public class Rectangle {
//     public int largestRectangleArea(int[] height) {
//         if (height.length == 0 || height == null) {
//         	return 0;
//         }

//         Stack<Integer> stack = new Stack<Integer>();
//         int max = 0;
//         int cur = -1;
//         int h, w;
//         for (int i = 0; i <= height.length; ++i) {
//         	if (i  == height.length) {
//         		cur = -1;
//         	}
//         	else {
//         		cur = height[i];
//         	}

//     		while (!stack.isEmpty() && cur < height[stack.peek()]) {
//     			h = height[stack.pop()];
//     			if (stack.isEmpty()) {
//     				w = i;
//     			}
//     			else {
//     				w = i - 1 - stack.peek();
//     			}
//     			max = Math.max(max, h * w);
//     		}
//     		stack.push(i);
//         }

//         return max;
//     }
// }
