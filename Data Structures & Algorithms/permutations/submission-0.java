class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        traverseAndPopulate(nums, 0, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }


    public void traverseAndPopulate(int[] nums, int currentIndex, List<Integer> subAns, boolean[] visit) {
        if (currentIndex == nums.length) {
            result.add(new ArrayList<>(subAns));
            return;
        }
        for(int i = 0; i < nums.length; i++) {

            if(visit[i]) continue;

            subAns.add(nums[i]);
            visit[i] = true;
            
            traverseAndPopulate(nums, currentIndex+1, subAns, visit);
            subAns.remove(subAns.size() - 1);
            visit[i] = false;

        }

    }
}
