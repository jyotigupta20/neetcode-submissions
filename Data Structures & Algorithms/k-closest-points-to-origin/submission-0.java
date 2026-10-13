class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // x2^2 + y2^2 - x1^2 + y1^2
        // sqrt(x1 - x2)^2 + (y1 - y2)^2) = x1^2 + x2^2 - 2*x1*x2 + y1^2 + y2^2 - 2*y1*y2
        // => x1^2 + x2^2 + y1^2 + y2^2
       PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1] )); 

       for(int[] point : points) {
        heap.offer(point);
        if(heap.size() > k) {
            heap.poll();
        }
       }

       int result[][] = new int[k][2];
       int i=0;
        while(!heap.isEmpty()){
            result[i] = heap.poll();
            i++;
        }

        return result;
    }
}
