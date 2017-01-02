
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        
        // create pre requisite list
        List<List<Integer>> preList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            List<Integer> list = new ArrayList<Integer>();
            preList.add(list);
        }
        // fill and count the # of pre-requisite
        int[] preNum = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            ++preNum[prerequisites[i][0]];
            preList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (preNum[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int courseId = queue.poll();
            res[count++] = courseId;
            List<Integer> list = preList.get(courseId);
            // decrease the prerequisite
            for (int id : list) {
                if (--preNum[id] == 0) {
                    queue.offer(id);
                }
            }
        }
        
        if (count == numCourses) {
            return res;
        }
        else {
            return new int[0];
        }
    }
}
