class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        findPermutation(nums, new ArrayList<>(), 0, new boolean[nums.length]);
        return res;
    }

    public void findPermutation(int[] nums, List<Integer> subRes, int currentIndex, boolean[] visit) {

        if(currentIndex == nums.length) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            subRes.add(nums[i]);
            findPermutation(nums, subRes, currentIndex+1, visit);
            subRes.remove(subRes.size() - 1);
            visit[i] = false;

        }
        

    }
}
