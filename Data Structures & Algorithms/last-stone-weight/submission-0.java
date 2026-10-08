class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s2,s1));
        for(int stone : stones) {
            pq.add(stone);
        }
        while(pq.size() > 1){
            int st1 = pq.remove();
            int st2 = pq.remove();
            if(st1 == st2) continue;
            pq.add(Math.abs(st1-st2));

        }
        if (pq.isEmpty()) return 0;
        return pq.remove();
        
    }
}
