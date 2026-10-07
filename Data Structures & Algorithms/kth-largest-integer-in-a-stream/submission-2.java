class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (pq.peek() < num) {
                    pq.remove();
                    pq.add(num);
                }
            }
        }
        for(int i = 0; i < k - pq.size(); i++) {
            pq.add(Integer.MIN_VALUE);
        }
        
    }
    
    public int add(int val) {
        // System.out.println(pq);
        if (pq.size() == 0) {
            pq.add(val);
            return val;
        }
        if (pq.peek() < val) {
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}
