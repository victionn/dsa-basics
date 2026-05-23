/* 
Stack pop solution, hold a min stack

while a new value is larger than the front of the stack, pop it and set its index - the index

38, 30


*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stk = new Stack<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int[] indTemp = new int[]{i, temperatures[i]};
            while (!stk.isEmpty() && temperatures[i] > stk.peek()[1]) {
                int[] toSet = stk.pop();
                //put it on the return array
                ret[toSet[0]] = i - toSet[0];
            }
            stk.push(indTemp);
        }
        int size = stk.size();
        for (int i = 0; i < size; i++) {
            int[] indTemp = stk.pop();
            ret[indTemp[0]] = 0;
        }
        return ret;
    }
}
