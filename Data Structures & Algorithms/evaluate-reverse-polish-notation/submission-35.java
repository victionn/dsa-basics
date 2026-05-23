class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> cal = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        for (String c : tokens) {
            if (c.equals("+")) {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num1 + num2);
            }
            else if (c.equals("-")) {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num2 - num1);
            }
            else if (c.equals("*")) {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num1 * num2);
            }
            else if (c.equals("/")) {
                num2 = cal.pop();
                num1 = cal.pop();
                cal.push(num1 / num2);
            }
            else {
                cal.push(Integer.parseInt(c));
            }            

        }
        return cal.pop();
        
    }
}
