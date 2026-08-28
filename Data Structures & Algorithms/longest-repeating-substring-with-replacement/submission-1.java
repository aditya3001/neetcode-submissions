class Solution {
    public int characterReplacement(String s, int k) {

        if (s.length() <= k) return s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while(right < s.length()) {
            freqMap.put(s.charAt(right), freqMap.computeIfAbsent(s.charAt(right), key -> {return 0;}) + 1);
            int maxCount = 0;
            for(Character charKey : freqMap.keySet()) {
                maxCount = Math.max(freqMap.get(charKey), maxCount);
            }
            int len = right - left + 1;
            if (len - maxCount > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);

                left++;
            } else {
                maxLen = Math.max(len,maxLen);
            }
            

            right++;

        }

        return maxLen;
        
    }
}
