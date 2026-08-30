class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() ) return "";
        if (s.equals(t)) return s;


        Map<Character, Integer> sFreqMap = new HashMap<>();
        Map<Character, Integer> tFreqMap = new HashMap<>();

        for(int i = 0; i< t.length(); i++) {
            tFreqMap.put(t.charAt(i), tFreqMap.computeIfAbsent(t.charAt(i), key-> {return 0;}) +1);
             
        }
        int l = 0, r = 0;
        int ansLength = Integer.MAX_VALUE;
        int ansLeft = 0 ;
        while (r < s.length()) {
            sFreqMap.put(s.charAt(r), sFreqMap.computeIfAbsent(s.charAt(r), key-> {return 0;}) +1);
            while (compareFreqMap(sFreqMap, tFreqMap)) {
                // System.out.println(l + " " + r);

                if (r-l+1 < ansLength ) {
                    ansLength = r-l+1;
                    ansLeft = l;
                }
                sFreqMap.put(s.charAt(l), sFreqMap.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
            
        }

        return ansLength == Integer.MAX_VALUE ? "":s.substring(ansLeft, ansLeft + ansLength);
        
    }


    private boolean compareFreqMap(Map<Character, Integer> sFreqMap, Map<Character, Integer> tFreqMap) {

        for (Character key : tFreqMap.keySet()) {
           

            if (tFreqMap.get(key).intValue() > sFreqMap.getOrDefault(key, 0).intValue()) {
                return false;
            }
        }

        // System.out.println(sFreqMap + " " + tFreqMap);

        return true;
    }
}
