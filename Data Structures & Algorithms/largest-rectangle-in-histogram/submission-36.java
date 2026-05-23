/* 
Intuition: hold the height and index in a stack, iterate through array
while height < front of the stack, pop and get how far the index it is from the stack to get the height
generated for the index

1 2 3 

0 1 2
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        Stack<int[]> stk = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stk.isEmpty() && heights[i] < stk.peek()[1]) {
                int[] cleared = stk.pop();
                max = Math.max(max, cleared[1] * (i - cleared[0]));
                start = cleared[0];
            }
            stk.push(new int[]{start, heights[i]});
        }
        int size = stk.size();
        while (size > 0) {
            int[] cleared = stk.pop();
            max = Math.max((heights.length - cleared[0]) * cleared[1], max);
            size --;
        }
        return max;
    }
}
