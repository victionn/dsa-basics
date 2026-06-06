class Solution {
    /* 
    [1,5] [8,10] - > [1,7]
    ok, im thinking of a min heap solution where i add each interval into a min heap by start time
    and
    -on polling each one, i check if its start time is contained in the previous, time, and if its end time is more than the previous start time, if it is, i merge them together by prev[start] + curr[end]
    if not, i add the prev into the return array,
    n log n time to poll each one
    n size complexity
    */
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> timeHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            timeHeap.add(interval);
        }
        int[] prev;
        int[] curr;

        List<int[]> mergedInterval = new ArrayList<>();
        while (! timeHeap.isEmpty()) {
            prev = timeHeap.poll();
            curr = timeHeap.isEmpty() ? null : timeHeap.peek();
            while (curr != null && curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
                timeHeap.poll();
                curr = timeHeap.isEmpty() ? null : timeHeap.peek();
            }
            mergedInterval.add(prev);
        }
        return mergedInterval.toArray(new int[0][]);

        
    }
}