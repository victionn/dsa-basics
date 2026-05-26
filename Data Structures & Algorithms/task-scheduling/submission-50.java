class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for(char c : tasks) {
            bucket[c - 'A'] ++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int max_value = 0;
        int counter = 0;
        for (int i : bucket) {
            if (i != 0) {
                pq.add(i);
                max_value = Math.max(max_value, i);
                counter ++;
            }
        }
        if (max_value == 1) {
            return counter;
        }
        Deque<int[]> deck = new ArrayDeque<>();
        int t = 0;
        while (!pq.isEmpty() || !deck.isEmpty()) {
            if (!pq.isEmpty()) {
                if (pq.peek() != 1) {
                    deck.addLast(new int[]{pq.poll() - 1, t + n});
                }      
                else {
                    pq.poll();
                }
            }
            else {
                t = deck.peekFirst()[1];
            }
            if (!deck.isEmpty() && deck.peekFirst()[1] == t) {
                int[] toAdd = deck.pollFirst();
                if (toAdd[0] > 0) {
                    pq.add(toAdd[0]);
                }
            }
            t++;
        }
        return t;
    }
}
