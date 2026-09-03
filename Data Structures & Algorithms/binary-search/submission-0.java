class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int s, int l) {
        if (l < s) return -1;
        int mid = s + (l - s)/2;
        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, l);
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, s, mid - 1);
        } else {
            return mid;
        }
    }
}
