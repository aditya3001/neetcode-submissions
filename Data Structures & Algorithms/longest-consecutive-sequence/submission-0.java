class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> arrSet = new HashSet<>();

        for (int num : nums) {
            arrSet.add(num);
        }
        int maxLength = 0;
        for (int num : arrSet) {
            if (arrSet.contains(num-1)) {
                continue;
            }
            int currentLength = 1;
            int currentElement = num+1;
            while(arrSet.contains(currentElement)) {
                currentLength+=1;
                currentElement+=1;
            } 

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

        }
        return maxLength;
        
    }
}