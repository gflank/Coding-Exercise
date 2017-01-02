
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int len = prerequisites.length;
        if (len == 0) {
            return true;
        }

        // construct the pre-requisite list first (indicates that this course is prerequisite of what)
        // create empty lists
        List<List<Integer>> preList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            preList.add(list);
        }
        // fill them & count the number of prerequisites for every course
        int[] preNum = new int[numCourses];
        for (int i = 0; i < len; ++i) {
            preList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNum[prerequisites[i][0]]++;
        }
        
        // queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // put all courses with no prerequisite into queue
        for (int i = 0; i < numCourses; ++i) {
            if (preNum[i] == 0) {
                queue.offer(i);
            }
        }
        
        // count for remaining courses
        int count = numCourses;
        // start to taking courses
        while (!queue.isEmpty()) {
            int courseId = queue.poll();
            --count;
            List<Integer> list = preList.get(courseId);
            // decrease the # of prerequisite for other courses
            for (int id : list) {
                if (--preNum[id] == 0) {
                    queue.offer(id);
                }
            }
        }
        
        return count == 0;
    }
}
