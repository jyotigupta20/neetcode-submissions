class Solution {
    public int countComponents(int n, int[][] edges) {
       Map<Integer, List<Integer>> graph = new HashMap<>();
       for(int i = 0; i<edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], key -> new ArrayList()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], key -> new ArrayList()).add(edges[i][0]);
       }
        Set<Integer> visit = new HashSet();
        int count = 0;
       for(int i =0; i< n; i++) {
            if(!visit.contains(i)) {
                dfs(graph, visit, i);
                count++;
            }
       }

       return count;
    }

    void bfs(Map<Integer, List<Integer>> graph, Set<Integer> visit, int node) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(node);
        visit.add(node);

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            if(graph.containsKey(currNode)) {
                for(int nei : graph.get(currNode)) {
                    if(!visit.contains(nei)) {
                        queue.offer(nei);
                        visit.add(nei);
                    }
                }
            }
        }
    }

    void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visit, int node) {
        visit.add(node);
        if(graph.containsKey(node)) {
            for(int nei: graph.get(node)){
                if(!visit.contains(nei)) {
                    dfs(graph, visit, nei);
                }
            }
        }
    }
}
