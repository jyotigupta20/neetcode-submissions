class Solution {
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    // }

private static final int UNVISITED = 0, VISITING = 1, DONE = 2;

public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);

    int[] state = new int[numCourses];
    for (int c = 0; c < numCourses; c++) {
        // Loop over ALL courses — the graph may be disconnected.
        if (state[c] == UNVISITED && hasCycle(c, adj, state)) return false;
    }
    return true;
}

private boolean hasCycle(int course, List<List<Integer>> adj, int[] state) {
    if (state[course] == VISITING) return true;   // back edge onto the current path
    if (state[course] == DONE) return false;      // subtree already proven clean

    state[course] = VISITING;                     // mark: on the path
    for (int next : adj.get(course)) {
        if (hasCycle(next, adj, state)) return true;
    }
    state[course] = DONE;                         // unmark: path done, subtree clean
    return false;
}
}
