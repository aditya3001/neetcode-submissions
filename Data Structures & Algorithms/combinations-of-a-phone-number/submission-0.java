class Solution {
    List<String> ans = new ArrayList<>();

    Map<String, String> numMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        numMap.put("2", "abc");
        numMap.put("3", "def");
        numMap.put("4", "ghi");
        numMap.put("5", "jkl");
        numMap.put("6", "mno");
        numMap.put("7", "pqrs");
        numMap.put("8", "tuv");
        numMap.put("9", "wxyz");

        traverseAndGenerate(digits, 0, new StringBuilder());
        return ans;

    }

    public void traverseAndGenerate(String digits, int currentIndex, StringBuilder subAns) {

        if(currentIndex >= digits.length()) {
            if (subAns.length() == 0) return;
            ans.add(subAns.toString());
            return;
        }

        String subRes = numMap.get(digits.substring(currentIndex, currentIndex+1));

        for(char c : subRes.toCharArray()) {
            subAns.append(c);
            traverseAndGenerate(digits, currentIndex+1, subAns);
            subAns.deleteCharAt(subAns.length() - 1);
        }


    }
}
