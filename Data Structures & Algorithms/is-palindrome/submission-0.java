class Solution {
    public boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        sLower = sLower.replace(" ", "");
        int i = 0, j = sLower.length() - 1;
        while (i < j) {
            while(!Character.isLetterOrDigit(sLower.charAt(i)) && i < j) i++;
            while(!Character.isLetterOrDigit(sLower.charAt(j)) && i < j) j--;
            if (sLower.charAt(i) != sLower.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
