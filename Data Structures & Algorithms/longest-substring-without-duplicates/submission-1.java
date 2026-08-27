class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> charMap = new HashMap<>();   
        int l = 0; int r = 1;
        int maxAns = 0;
        charMap.put(s.charAt(l), l);
        while (r < s.length()) {
            // System.out.println("charMap " + charMap);
            if (charMap.keySet().contains(s.charAt(r))) {
                int newl = charMap.get(s.charAt(r))+1;
                // System.out.println("newL " + newl);
                while(l < newl) {
                    charMap.remove(s.charAt(l));
                    l++;
                }
                
            }
            charMap.put(s.charAt(r), r);
            // System.out.println(r + " " + l);
            maxAns = Math.max(maxAns, r-l+1);
            r++;
        }

        return maxAns;

    }
}

// l 0
// r 1
// 
