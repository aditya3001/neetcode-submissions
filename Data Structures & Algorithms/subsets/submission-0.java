class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traverseAndSelect(nums, 0, new ArrayList<>());
        return res;
    }

    public void traverseAndSelect(int[] nums, int currentIndex, List<Integer> subRes) {
        if(currentIndex >= nums.length) {
            // System.out.println(subRes + " "+ currentIndex);

            res.add(new ArrayList<>(subRes));
            return;
        }
        int idx = currentIndex+1; 
        traverseAndSelect(nums,idx, subRes);
        subRes.add(nums[currentIndex]);
        traverseAndSelect(nums,idx, subRes);
        subRes.remove(Integer.valueOf(nums[currentIndex]));



    }
}
