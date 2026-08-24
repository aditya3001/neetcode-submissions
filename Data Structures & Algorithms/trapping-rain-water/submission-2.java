class Solution {
    public int trap(int[] height) {

        // int leftMin = 0;
        // int currentIndex = 0;

        // int amount = 0;
        // int localAmount = 0;
        // while (currentIndex < height.length) {
        //     localAmount = 0;
        //     while ( currentIndex < height.length && height[currentIndex] < height[leftMin]) {
        //         localAmount+= height[leftMin] - height[currentIndex];
        //         currentIndex++;
        //         if (currentIndex == height.length){
        //             localAmount = 0;
        //             leftMin++;
        //             currentIndex = leftMin+1;
        //         }
        //     } 
        //     amount+= localAmount;
        //     leftMin = currentIndex;
        //     currentIndex++;

        // }

        // return amount;
        int leftMax = 0;
        int left = 0;

        int rightMax = height.length - 1;
        int right = height.length - 1;

        int amount = 0;
        while (left < right) {
            
            if(height[left] <= height[right]) {

                if (height[left] >= height[leftMax]){
                    leftMax = left;
                } else {
                    amount+= height[leftMax] - height[left];
                }
                left++;
                
            }else {
                if(height[rightMax] <= height[right]) {
                    rightMax = right;
                } else {
                    amount+=height[rightMax] - height[right];
                }     
                right--;
            }
            
            
        }

        return amount;
        
    }
}
// len 10
// leftMin 3
// currentIndex 4
// amount 2
// localAmount 2

// h[cI] 3
// h[leftMin] 3