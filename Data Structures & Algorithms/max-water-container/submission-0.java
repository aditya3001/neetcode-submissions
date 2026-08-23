class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int amount = 0;

        while (left < right) {
            int localAmount = Math.min(heights[left], heights[right])*(right - left);
            amount = Math.max(amount, localAmount);
            if(heights[left] < heights[right]) {
                left++;
            }else {
                right--;
            }
            

        }
        return amount;
        
    }
}
