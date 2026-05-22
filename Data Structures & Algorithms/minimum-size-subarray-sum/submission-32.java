class Solution {
    /* 


    */

    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int l = 0;
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            while (windowSum >= target) { 
                if (windowSum - nums[l] < target) {
                    min = Math.min(min, r - l + 1);
                    break;
                }
                windowSum -= nums[l];
                l++;
            }
            
        }       
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}