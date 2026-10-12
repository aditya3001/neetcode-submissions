class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traverseAndCalculate(nums,new ArrayList<>(), 0);
        return res;
        
    }

    public void traverseAndCalculate(int[] nums, List<Integer> subRes, int currentIndex) {

        if(currentIndex>= nums.length) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        subRes.add(nums[currentIndex]);
        int idx = currentIndex+1;
        traverseAndCalculate(nums,subRes, idx);
        subRes.remove(subRes.size() - 1);
        while(idx < nums.length && nums[idx] == nums[idx-1]) {
            idx++;
        }
        traverseAndCalculate(nums,subRes, idx);

    }
}
