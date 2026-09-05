class Solution {

    public class CustomInt {
        int val;
        int index;

        public CustomInt(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<CustomInt> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s2.val, s1.val));
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.offer(new CustomInt(nums[i], i));
        }
        ans[0] = pq.peek().val;
        int lI = k;
        int ansIndex = 1;
        while (lI < nums.length) {
            pq.offer(new CustomInt(nums[lI], lI));

            while (pq.peek().index < lI - k + 1) {
                pq.poll();
            }
            ans[ansIndex] = pq.peek().val;
            ansIndex++;
            lI++;
        }

        return ans;

    }
}
