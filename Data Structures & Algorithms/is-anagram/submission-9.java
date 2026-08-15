class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.computeIfAbsent(s.charAt(i), k -> {return 0;}) + 1);
            tMap.put(t.charAt(i), tMap.computeIfAbsent(t.charAt(i), k -> {return 0;}) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if (!sMap.get(s.charAt(i)).equals(tMap.get(s.charAt(i)))) {
                
                return false;
            }
        }

        return true;


    }
}
