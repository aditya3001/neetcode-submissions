class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1Array = new int[26];
        int[] freq2Array = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq2Array[s2.charAt(i) - 'a']+=1;
            freq1Array[s1.charAt(i) - 'a']+=1;

        }
        for (int j = 0; j < s2.length() - s1.length(); j++) {
            System.out.println(Arrays.toString(freq1Array) + " " + Arrays.toString(freq2Array));
            if (Arrays.toString(freq1Array).equals(Arrays.toString(freq2Array))) {
                return true;
            }
            freq2Array[s2.charAt(j) - 'a']-=1;
            freq2Array[s2.charAt(j + s1.length()) - 'a']+=1;
            
            

        }
        if (Arrays.toString(freq1Array).equals(Arrays.toString(freq2Array))) {
                return true;
            }
        return false;
        
        
    }
}
