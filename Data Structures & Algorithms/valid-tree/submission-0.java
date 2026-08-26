class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList();
        for(int i=0; i<n; i++) {
          graph.add(new ArrayList());  
        }
        for(int[] edge : edges) {
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new ArrayDeque();
        Set<Integer> visited = new HashSet();
        queue.offer(new int[]{0, -1});
        visited.add(0);
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for(int neigbour : graph.get(node)) {
                if(neigbour == parent) {
                    continue;
                }
                if(visited.contains(neigbour)) {
                    return false;
                }
                visited.add(neigbour);
                queue.offer(new int[]{neigbour, node});
            }
        }
        return visited.size() == n;
    }
}
