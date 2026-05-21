class Solution {
    //Greedy solution, keep looking using the max height
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxNum = Integer.MIN_VALUE;
        while (l < r) {
             maxNum = Math.max(maxNum, Math.min(heights[l], heights[r]) * (r - l));
             if (heights[l] > heights[r]) {
                r--;
             }
             else {
                l++;
             }
        }
        return maxNum;
    }
}
