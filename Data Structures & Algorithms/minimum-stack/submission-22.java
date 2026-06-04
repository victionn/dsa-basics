/* 
stack
3
1
5

deck
115
*/



class MinStack {
        ArrayDeque<Integer> deck;
        Stack<Integer> stk;
    public MinStack() {
        deck = new ArrayDeque<>();
        stk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val); 
        if (deck.isEmpty()) {
            deck.addFirst(val);
        }
        else {
            if (deck.peekFirst() > val) {
                deck.addFirst(val);
            }
            else {
                deck.addFirst(deck.peekFirst());
            }
        }
    }
    
    public void pop() {
        deck.pollFirst();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return deck.peekFirst();
    }
}
