class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> currentStack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while (!currentStack.isEmpty() && temperatures[currentStack.peek()] < temperatures[i]) {
                int lastTemp = currentStack.pop();
                ans[lastTemp] = i - lastTemp;
            }
            currentStack.push(i);
        }

        while (!currentStack.isEmpty()) {
            ans[currentStack.pop()] = 0;
        }

        return ans;
    }
}


// 30 38 30 36