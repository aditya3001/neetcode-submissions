class Solution {
    public boolean isValid(String s) {

        List<Character> openPara = List.of('(', '[', '{');
        List<Character> closePara = List.of(')', ']', '}');
        Stack<Character> paranStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (openPara.contains(s.charAt(i))) {

                paranStack.push(s.charAt(i));
            } else {
                if (paranStack.size() == 0) return false;

                if (s.charAt(i) == ')') {
                    if(paranStack.pop() == '(') {
                        continue;
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if(paranStack.pop() == '[') {
                        continue;
                    } else {
                        return false;
                    }
                } if (s.charAt(i) == '}') {
                    if(paranStack.pop() == '{') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (paranStack.size() != 0) return false;

        return true;
    }
}
