class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        Map<Integer, List<int[]>> destMap = new HashMap<>();

        for(int i = 0; i< flights.length; i++){
            destMap.computeIfAbsent(flights[i][0], key -> new ArrayList<>())
            .add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, src, 0});  
        // cost -> 0, currPlace -> src, no. of hops taken -> 0

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int currCost = node[0];
            int currPlace = node[1];
            int currStops = node[2];

            if(currStops > k) {
                continue;
            }

            for(int next[]: destMap.getOrDefault(currPlace, new ArrayList<>())) {
                int nextCost = next[1];
                int nextPlace = next[0];
                int totalCostF = currCost + nextCost;
                if(totalCostF < prices[nextPlace]) {
                    prices[nextPlace] = totalCostF;
                    queue.offer(new int[]{totalCostF, nextPlace, currStops+1});
                }
            }
        }

        if(prices[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return prices[dst];

    }
}
