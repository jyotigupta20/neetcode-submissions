class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> disMap = new HashMap();
        int n = points.length;
        for(int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j= i+1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1-x2) + Math.abs(y1-y2);
                disMap.computeIfAbsent(i, key -> new ArrayList<>()).add(new int[]{d, j});
                disMap.computeIfAbsent(j, key -> new ArrayList<>()).add(new int[]{d, i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int totalCost = 0;
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{0, 0});

        while(visited.size() < n && !minHeap.isEmpty()) {
            int curr[] = minHeap.poll();
            int currCost = curr[0];
            int currNode = curr[1];
            if(visited.contains(currNode)) {
                continue;
            }
            totalCost += currCost;
            visited.add(currNode);
            if(disMap.containsKey(currNode)) {
                for(int[] nei: disMap.get(currNode)) {
                     if(!visited.contains(nei[1])) {
                        minHeap.offer(new int[]{nei[0], nei[1]});
                     }
                }
            }

        }
    return totalCost;
    }
}
