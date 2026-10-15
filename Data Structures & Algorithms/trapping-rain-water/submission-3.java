class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = -1, rightMax = -1;
        int subResL=0, subResR=0, result=0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    // System.out.println("Here");
                    leftMax = height[left];
                    // result+=subResL;
                } else {

                    result+=leftMax - height[left];
                    // System.out.println("SubResL is " + subResL);

                }
                left++;
            }else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                    result+=subResR;
                } else {
                    result+=rightMax - height[right];
                }
                right--;
            }
            
        }

        return result;

        
    }
}
