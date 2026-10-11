class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates, 0, new ArrayList<>(), target, 0);
        return resList;
        
    }

    public void findCombination(int[] candidates, int idx, List<Integer> subRes, int target, int sum) {
        if (sum == target) {
            resList.add(new ArrayList<>(subRes));
            return;
        }
        if(idx >= candidates.length || sum > target) return;

        int updatedIndex = idx + 1;
        
        if (sum + candidates[idx] <= target) {
            
            sum = sum + candidates[idx];
            subRes.add(candidates[idx]);
            findCombination(candidates, updatedIndex, subRes, target, sum);
            sum = sum - candidates[idx];
            subRes.remove(subRes.size() - 1);
            while (updatedIndex < candidates.length && candidates[updatedIndex] == candidates[updatedIndex - 1]) {
                updatedIndex++;
            }
            findCombination(candidates, updatedIndex, subRes, target, sum);
        }
        



    }
}
