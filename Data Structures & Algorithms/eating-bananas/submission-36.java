class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int l = 0;
        int r = max;
        int candidate = 0;  
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = 0;
            for (int i : piles) {
                time += Math.ceil(i / (double) mid);
            }
            if (time <= h) {
                candidate = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return candidate;
    }
}
