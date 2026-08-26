class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            intSet.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            if(intSet.contains(nums[i] - 1)) {
                continue;
            }
            int nextVal = nums[i]+1;
            int localAns = 1;
            while (intSet.contains(nextVal)) {
                localAns++;
                nextVal++;
            }
            ans = Math.max(ans, localAns);
        }
        return ans;

    }
}
