class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxVal = -1;
        for(int pile : piles) {
            maxVal = Math.max(pile, maxVal);
        }

        int start = 1;
        int end = maxVal;

        while(start < end) {

            int mid = start + (end - start)/2;

            if (calculateHour(piles, mid) > h) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return end;

    }

    public int calculateHour(int[] piles, int k) {
        int hr = 0;

        for(int pile : piles) {
            hr+= (pile + k - 1)/k;
        }

        return hr;

    }
}
