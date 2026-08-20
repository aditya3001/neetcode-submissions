class Solution {

    public int[] productExceptSelf(int[] nums) {
        // Solution 1
        // int product = 1;
        // boolean singleZero = false;
        // for(int num : nums) {
        //     if (num == 0 && !singleZero) {
        //         singleZero = true;
        //         continue;
        //     }
        //     product *= num;
        // }
        // int[] ans = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         ans[i] = product;
        //         continue;
        //     }
        //     if (singleZero) {
        //         ans[i] = 0;
        //         continue;
        //     }
        //     ans[i] = product/nums[i];
        // }
        // return ans;

        // Solution 2
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];
        int[] ans = new int[nums.length];
        Arrays.fill(prefixProd, 1);
        Arrays.fill(suffixProd, 1);

        for(int i = 1; i < nums.length; i++) {
            prefixProd[i] = nums[i-1]*prefixProd[i-1];
        }

        for(int i = nums.length -2; i >=0; i--) {
            suffixProd[i] = nums[i+1]*suffixProd[i+1];
        }

        for(int i = 0; i < nums.length; i++) {
            ans[i] = prefixProd[i]*suffixProd[i];
        }
        return ans;
    }
}  
