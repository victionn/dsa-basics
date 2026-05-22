class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        for (String s: operations) {
            if(s.equals("+")) {
                num1 = stk.pop();
                num2 = stk.pop();
                int total = num1 + num2;
                stk.push(num2);
                stk.push(num1);
                stk.push(total);
            }
            else if (s.equals("D")) {
                num1 = stk.pop();
                int total = num1 * 2;
                stk.push(num1);
                stk.push(total);
            }
            else if (s.equals("C")) {
                stk.pop();
            }
            else {
                stk.push(Integer.parseInt(s));
            }
        }
        int total = 0;
        while (!stk.isEmpty()) {
            total += stk.pop();
        }
        return total;
    }
}