/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneGraphMap = new HashMap();
        return dfs(node, cloneGraphMap);
    }
    // public Node cloneGraph(Node node) {
    //     return bfs(node);
    // }

    Node dfs(Node node, Map<Node, Node> cloneGraphMap) {
        if(node == null) {
            return null;
        }

        if(cloneGraphMap.containsKey(node)) {
            return cloneGraphMap.get(node);
        }

        Node clone = new Node(node.val);
        cloneGraphMap.put(node, clone);
        for(Node neighbor: node.neighbors) {
            clone.neighbors.add(dfs(neighbor, cloneGraphMap));
        }

        return clone;
    }

    Node bfs(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> cloneGraphMap = new HashMap();
        Queue<Node> queue = new LinkedList();
        Node clone = new Node(node.val);
        cloneGraphMap.put(node, clone);
        queue.offer(node);

        while(!queue.isEmpty()) {
           Node curr = queue.poll();
           for(Node neighbor: node.neighbors) {
            if(!cloneGraphMap.containsKey(neighbor)) {
               cloneGraphMap.put(neighbor, new Node(neighbor.val));
               queue.offer(neighbor);
            }
            cloneGraphMap.get(curr).neighbors.add(cloneGraphMap.get(neighbor));
           }
        }
      return cloneGraphMap.get(node);    
    }
}