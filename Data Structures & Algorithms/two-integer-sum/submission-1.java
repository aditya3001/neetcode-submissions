class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> deltaMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (deltaMap.getOrDefault(nums[i], -1) != -1) {
                return new int[]{deltaMap.get(nums[i]), i};
            }
            deltaMap.put(delta, i);

        }

        return new int[]{};
    }
}
