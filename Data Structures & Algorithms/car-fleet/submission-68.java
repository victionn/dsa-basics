/* 
position = 1, 4          position = 1 4            
speed = 3, 2             ttf =      3 3
target = 10

*/


class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] tTF = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            double finish =  (double) (target - position[i]) / (double) speed[i];
            tTF[i] = new double[]{position[i], finish}; 
        }
        Arrays.sort(tTF, (a, b) -> Double.compare(b[0], a[0]));
         // if head stack ttf >= curr, next, otherwise add to stack, return stsack size
         Stack<double[]> stk = new Stack<>();
         stk.push(tTF[0]);
         for (int i = 1; i < tTF.length; i++) {
            if (stk.peek()[1] < tTF[i][1]) {
                stk.push(tTF[i]);
            }
         } 
         return stk.size();
        
    }
}
