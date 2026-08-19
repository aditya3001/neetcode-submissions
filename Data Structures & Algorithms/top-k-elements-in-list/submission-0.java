class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freqArray = new ArrayList[nums.length+1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.computeIfAbsent(num, kt -> {return 0;}) + 1);
        }
        for(int key : freqMap.keySet()) {
            if(freqArray[freqMap.get(key)] == null) {
                freqArray[freqMap.get(key)] = new ArrayList<>();
            }
            freqArray[freqMap.get(key)].add(key);
        }
        int index = freqArray.length - 1;
        int kIndex = 0;
        int[] ans = new int[k];
        while (index >= 0) {
            if (freqArray[index] == null) { 
                index--;
                continue;
            }
            System.out.println(freqArray[index]);

            if (kIndex >= k) return ans;
            for (int j = 0; j < freqArray[index].size(); j++) {
                if (kIndex < k) {
                    ans[kIndex] = freqArray[index].get(j);
                    kIndex++;
                } else {
                    return ans;
                }
            }
            index--;

        }
        return ans;

    }
}
