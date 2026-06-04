/* 

-1 2

+ = ->
- = <- 

- + 
<- ->

+ -
-> <-
-2 -5 5 3
*/


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int num : asteroids) {
            boolean broken = false;
            while (!stk.isEmpty() && stk.peek() > 0 && num < 0) {
                //Same size
                if (stk.peek() == Math.abs(num)) {
                    stk.pop();
                    broken = true;
                    break;
                }
                //asteroid in the stack is smaller
                if (stk.peek() < Math.abs(num)) {
                    stk.pop();
                    continue;
                }
                //asteroid in the stack is larger
                if (stk.peek() > Math.abs(num)) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                stk.push(num);
            }
        }
        
        int[] ret = new int[stk.size()];
        int s = stk.size();
        for (int i = s - 1; i >= 0; i--) {
            ret[i] = stk.pop();
        }
        return ret;
    }
}