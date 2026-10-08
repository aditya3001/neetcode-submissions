class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] charArray = new int[26];
        Set<Character> charSet = new HashSet<>();
        for(char task : tasks) {
            charArray[task - 'A'] += 1;
            charSet.add(task);
        }

        Queue<Character> charQ = new LinkedList<>();
        PriorityQueue<Character> charPQ = new PriorityQueue<>((c1, c2) -> Integer.compare(charArray[c2-'A'], charArray[c1 - 'A']));
        for(char c : charSet) {
            charPQ.add(c);
        }


        int t;
        int result = 0;
        while (!charPQ.isEmpty()) {
            t = n+1;
            while(t!= 0) {
                if(charPQ.isEmpty()) {
                    if (!charQ.isEmpty()) {
                        result += t;
                    }
                    t = 0;

                }else {
                    char c = charPQ.remove();
                    charArray[c - 'A'] -= 1;
                    t--;
                    result++;
                    if(charArray[c - 'A'] > 0) {
                        charQ.add(c);
                        
                    }
                    
                } 
            }
            while(!charQ.isEmpty()){
                 charPQ.add(charQ.remove());
                
            }


        }

        return result;
        
    }
}
