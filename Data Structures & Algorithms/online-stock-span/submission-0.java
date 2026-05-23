/* 
hold a min stack of {cost, days its been less}
any time the top of the stack is found to be less than the number, pop it and add its number of days to it 

for exampel
*/


class StockSpanner {
    Stack<int[]> stockHolder;
    public StockSpanner() {
        stockHolder = new Stack<>();
    }
    
    public int next(int price) {
        int consecDays = 1; 
        while (!stockHolder.isEmpty() && stockHolder.peek()[0] <= price) {
            consecDays += stockHolder.pop()[1];
            
        }
        stockHolder.push(new int[]{price, consecDays});
        return consecDays;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */