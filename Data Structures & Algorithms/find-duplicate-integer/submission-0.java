class Solution {
    public int findDuplicate(int[] nums) {

        int slow = 0, fast = 0;
        boolean start = true;

        while(start || nums[slow] != nums[fast]) {
            start = false;

            slow = nums[slow];
            fast = nums[nums[fast]];

        }
        int slow2 = 0;
        while (nums[slow] != nums[slow2]) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return nums[slow];
        
    }
}
