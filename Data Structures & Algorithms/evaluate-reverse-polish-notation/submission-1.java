class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> numStorage = new Stack<>();
        List<String> operatorsList = List.of("+", "-", "*", "/");
        for(String token : tokens) {

            if (!operatorsList.contains(token)) {
                numStorage.push(token);
            } else {
                int num2 = Integer.valueOf(numStorage.pop());
                int num1 = Integer.valueOf(numStorage.pop());
                if (token.equals("+")) numStorage.push(String.valueOf(num1+num2));
                if (token.equals("-")) numStorage.push(String.valueOf(num1-num2));
                if (token.equals("*")) numStorage.push(String.valueOf(num1*num2));
                if (token.equals("/")) numStorage.push(String.valueOf(num1/num2));

            }

        }
        // System.out.println(numStorage);
        return Integer.valueOf(numStorage.pop());
    }
}
