class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2) {
            while (i > 0 && i < nums.length - 2 && nums[i-1] == nums[i]) {
                i++;
            }
            int target = 0 - nums[i];
            List<List<Integer>> twoSumAns = twoSum(nums, i, target);
        
            ans.addAll(twoSumAns);
            i++;

        }

        return ans;
        
    }

    public List<List<Integer>> twoSum(int[] nums, int i, int target) {
        // System.out.println(i + "  "+ target);
        List<List<Integer>> ans = new ArrayList<>();
        int j = i+1;
        int k = nums.length - 1;
        while (j < k) {
            
            // System.out.println(target + " " + nums[j] + "  "+ nums[k]);
            int sum = nums[j] + nums[k];
            if (sum == target){
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                while (j < k && nums[j] == nums[j+1]){
                    j++;
                }
                while (j < k && nums[k] == nums[k-1]){
                    k--;
                }
                k--;
                j++;
                continue;
            }
            
            if (sum > target) {
                k--;
            } else {
                j++;
            }
            
        }
        return ans;

    }
}
