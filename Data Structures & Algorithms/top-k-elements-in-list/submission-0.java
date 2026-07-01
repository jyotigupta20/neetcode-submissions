class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }

        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                System.out.println("Array doesn't have enough elements");
                break;
            }
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
