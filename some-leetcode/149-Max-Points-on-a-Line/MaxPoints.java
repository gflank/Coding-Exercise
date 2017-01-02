// Max Points on a Line Total Accepted: 38432 Total Submissions: 305795 My Submissions Question Solution 
// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

// Hide Tags Hash Table Math

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.util.*;

public class MaxPoints {
    public int maxPoints(Point[] points) {
        if (points == null) {
        	return 0;
        }

        int max = 0;
        int same;
        float slope;
        int countTemp;
        int singleMax;
        HashMap<Float, Integer> slopeMap = new HashMap<Float, Integer>();
        for (Point thisP : points) {
        	same = 0;
        	singleMax = 0;
        	slopeMap.clear();
        	for (Point otherP : points) {
        		if (thisP.x == otherP.x) {
        			if (thisP.y == otherP.y) {
        				++same;
        				continue;
        			}
        			if (!slopeMap.containsKey(Float.MAX_VALUE)) {
        				countTemp = 1;
	        			slopeMap.put(Float.MAX_VALUE, countTemp);
        			}
        			else {
        				countTemp = slopeMap.get(Float.MAX_VALUE) + 1;
	        			slopeMap.put(Float.MAX_VALUE, countTemp);
        			}
        		}
        		else {
        			slope = (float)(thisP.y - otherP.y) / (thisP.x - otherP.x);
        			if (!slopeMap.containsKey(slope)) {
        				countTemp = 1;
	        			slopeMap.put(slope, countTemp);    				
        			}
        			else {
        				countTemp = slopeMap.get(slope) + 1;
	        			slopeMap.put(slope, countTemp);
        			}
        		}
        		singleMax = Math.max(singleMax, countTemp);
        	}
        	max = Math.max(max, singleMax + same);
        }

        return max;
    }
}
