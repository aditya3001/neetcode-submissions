class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Solution 1
        int product = 1;
        boolean singleZero = false;
        for(int num : nums) {
            if (num == 0 && !singleZero) {
                singleZero = true;
                continue;
            }
            product *= num;
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = product;
                continue;
            }
            if (singleZero) {
                ans[i] = 0;
                continue;
            }
            ans[i] = product/nums[i];
        }
        return ans;
    }
}  
