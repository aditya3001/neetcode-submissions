class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((f1, f2) -> {
            double dist1 = Math.sqrt(Math.pow(f1[0], 2) + Math.pow(f1[1], 2));
            double dist2 = Math.sqrt(Math.pow(f2[0], 2) + Math.pow(f2[1], 2));
            return Double.compare(dist2, dist1);
            });


        for(int[] point : points) {
            if (pq.size() < k) {
                pq.add(point);
            } else {
                double currentDistance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
                double pqPeekDistance = Math.sqrt(Math.pow(pq.peek()[0], 2) + Math.pow(pq.peek()[1], 2));

                if (pqPeekDistance > currentDistance) {
                    pq.remove();
                    pq.add(point);
                }
            }
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
        

    }
}
