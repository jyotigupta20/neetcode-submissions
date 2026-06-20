class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int prevEnd = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                res++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }
}
