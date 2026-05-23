/*
0-10
5


*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        int l = 0;
        int r = sum;
        int candidate = 0;
        while (l <= r) {
            //Choose the weight capacity
            int mid = l + (r - l) / 2;
            int currShip = 0;
            int counter = 1;
            boolean canCarry = true;
            for (int i : weights) {
                if (i > mid) {
                    canCarry = false;
                    break;
                }
                if (currShip + i <= mid) {
                    currShip += i;
                }
                else {
                    currShip = i;
                    counter ++;
                }
            }
            //If counter exceeded amount of days or weight is not enough, need to carry more weiht
            if (counter > days ||  !canCarry) {
                l = mid + 1;
            }
            else {
                candidate = mid;
                r = mid - 1;
            }
        }
        return candidate;
    }
}