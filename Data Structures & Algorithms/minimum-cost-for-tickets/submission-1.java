class Solution {
    // public int mincostTickets(int[] days, int[] costs) {
    //     if(days == null || costs == null || days.length == 0 || costs.length != 3) {
    //         return 0;
    //     }

    //     Queue<int[]> queue7days = new LinkedList();
    //     Queue<int[]> queue30days = new LinkedList();
    //     int minCost = 0;

    //     for(int currDay : days) {

    //         while(!queue7days.isEmpty() && queue7days.peek()[0] + 7 <= currDay) {
    //             queue7days.poll();
    //         }
    //          while(!queue30days.isEmpty() && queue30days.peek()[0] + 30 <= currDay) {
    //             queue7days.poll();
    //         }
    //         queue7days.offer(new int[]{currDay, minCost + costs[1]});
    //         queue30days.offer(new int[]{currDay, minCost + costs[2]});
    //         minCost = Math.min(minCost + costs[0], Math.min(queue7days.peek()[1], queue30days.peek()[1]));
    //     }
    //     return minCost;
    // }

    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null || days.length == 0 || costs.length != 3) {
            return 0;
        }
        int dp[] = new int[366];
        int currDay = 0;

        for(int i = 1; i < 366; i++) {
            dp[i] = dp[i-1];

            if(currDay == days.length) {
                return dp[i];
            }
            if(i == days[currDay]) {
                dp[i] += costs[0];
                dp[i] = Math.min(dp[i], costs[1] + dp[Math.max(0, i-7)]);
                dp[i] = Math.min(dp[i], costs[2] + dp[Math.max(0, i-30)]);
                currDay++;
            }
        }

        return dp[365];
    }
}