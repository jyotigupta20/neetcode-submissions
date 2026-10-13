class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

      for(int stone : stones) {
        queue.offer(stone);
      }

      while(queue.size() > 0) {
        int first = queue.poll();
        if(queue.size() == 0) {
            return first;
        }
        int second = queue.poll();
        int diff = Math.abs(first-second);
        if(diff > 0) {
           queue.offer(diff); 
        }
      }

      return 0;
    }
}
