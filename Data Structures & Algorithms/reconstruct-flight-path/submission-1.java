class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0),
            k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList();
        Stack<String> stack = new Stack();

        stack.push("JFK");

        while(!stack.isEmpty()) {
            String curr = stack.peek();
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                result.addFirst(stack.pop());
            } else {
                stack.push(adj.get(curr).poll());
            }
        }
        return result;
    }
}
