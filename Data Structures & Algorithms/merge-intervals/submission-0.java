class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int curr = 0;
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int lastEnd = res.get(res.size() - 1)[1];
            if (currStart <= lastEnd) {
                res.get(res.size() - 1)[1] = Math.max(currEnd, lastEnd);
            } else {
                res.add(new int[]{currStart, currEnd});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
