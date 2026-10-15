class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        traverseAndPartition(s, 0, new ArrayList<>());
        return result;
    }

    public void traverseAndPartition(String s, int currentIndex, List<String> subAns) {

        if (s.isEmpty()) {
            result.add(new ArrayList<>(subAns));
            return;
        }
        if(currentIndex >= s.length()) return;
        String sub = s.substring(0,currentIndex+1);

        boolean isP = isPallindrome(sub);
        if (isP){

            subAns.add(sub);
            traverseAndPartition(s.substring(currentIndex + 1, s.length()), 0, subAns);
            subAns.remove(subAns.size() - 1);
        } 

        traverseAndPartition(s, currentIndex+1, subAns);


    }

    public boolean isPallindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if (s.charAt(left)!= s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
        
    }
}
