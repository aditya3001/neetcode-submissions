class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        findCombination(nums, 0, target, new ArrayList<>());
        return result;
    }

    public void findCombination(int[] nums, int idx, int target, List<Integer> subRes) {
        int sum = subRes.stream().mapToInt(Integer::intValue).sum();
        if ( sum == target) {
            result.add(new ArrayList<>(subRes));
            return;
        }
        if(idx >= nums.length || sum > target) {
            return;
        }
        

        subRes.add(nums[idx]);
        findCombination(nums, idx, target, subRes);
        subRes.remove(Integer.valueOf(nums[idx]));
        findCombination(nums, idx + 1, target, subRes);

    }
}
