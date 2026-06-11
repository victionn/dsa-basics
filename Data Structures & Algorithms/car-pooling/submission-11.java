class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int curr = 0;
        for (int i = 0; i < trips.length; i++) {
            curr += trips[i][0];
            while (!pq.isEmpty() && trips[i][1] >= pq.peek()[2]) {
                curr -= pq.poll()[0];
            }
            if (curr > capacity)  {
                return false;
            } 
            pq.add(trips[i]);
        }
        return true;

    }
}