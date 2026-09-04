class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] combArray = new int[position.length][3];
        for (int i = 0 ; i < position.length ; i++) {
            combArray[i][0] = position[i];
            combArray[i][1] = speed[i];
        }
        Arrays.sort(combArray, (k1, k2) -> {
            return Integer.compare(k2[0], k1[0]);
        });
        Stack<Double> intStack = new Stack<>();
        for(int j = 0 ; j < position.length; j++) {
            double val = ((double) target - (double) combArray[j][0] )/(double) combArray[j][1];
            if (intStack.isEmpty()) {
                intStack.push(val);
                continue;
            }
            if (val > intStack.peek()) {
                intStack.push(val);
            }
        }

        return intStack.size();
        
    }
}
