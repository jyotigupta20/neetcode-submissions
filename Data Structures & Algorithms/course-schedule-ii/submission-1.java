class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList();

        for(int i =0; i< numCourses; i++) {
              graph.add(new ArrayList());  
        }
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque();
        for(int i =0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int orderIndex = 0;

        while(!queue.isEmpty()) {
            int course = queue.poll();
            result[numCourses - orderIndex - 1] = course;
            orderIndex++;
            for(int depCourse: graph.get(course)) {
                indegree[depCourse]--;
                if(indegree[depCourse] == 0) {
                    queue.offer(depCourse);
                }
            }
        }

        if(orderIndex != numCourses) {
            return new int[0];
        }
        return result; 
    }
}
