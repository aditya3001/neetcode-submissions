class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, new StringBuilder(), 0);
        return res;
    }

    public void generate(int remaining, StringBuilder subAns, int toBeCompleted) {
        if (remaining == 0 && toBeCompleted == 0) {
            res.add(subAns.toString());
            return;
        }

        if (remaining > 0) {
            subAns.append("(");
            generate(remaining - 1, subAns, toBeCompleted+1);
            subAns.deleteCharAt(subAns.length() - 1);
        }

        
        if (toBeCompleted > 0) {
            subAns.append(")");
            generate(remaining, subAns, toBeCompleted-1);
            subAns.deleteCharAt(subAns.length() - 1);

        }
        

    }
}
