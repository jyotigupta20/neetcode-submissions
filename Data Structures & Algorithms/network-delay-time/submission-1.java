class Solution {
    public int networkDelayTime(int[][] times, int n, int k) { 
        Map<Integer, List<int[]>> nodeMap = new HashMap<>();
        for(int[] time : times) {
           nodeMap.computeIfAbsent(time[0],
           key -> new ArrayList<>()).add(new int[] {time[1], time[2]}); 
        }

        Set<Integer> visted = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0,k});
        int totalCost = 0;
        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int currNode = node[1];
            int currWeight = node[0];
            if(visted.contains(currNode)) {
                continue;
            }
                totalCost = currWeight;
                visted.add(currNode);
                if(nodeMap.containsKey(currNode)) {
                    for( int[] tn: nodeMap.get(currNode)) {
                        if(!visted.contains(tn[0])) {
                            minHeap.offer(new int[]{currWeight + tn[1], tn[0]});
                        } 
                    }
                }
        }
    if(visted.size() == n) {
        return totalCost;
    } 
    return -1;
    }
}
