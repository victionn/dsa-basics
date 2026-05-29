class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Integer> ret = new ArrayList<>();
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i = 0; i < tasks.length; i++) {
            pq.add(new int[]{tasks[i][0], tasks[i][1], i});
        } 
        //Will compare shortest processing time and smallest index 
        PriorityQueue<int[]> processQueue = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int t = 0;

        while (!pq.isEmpty() || !processQueue.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= t) {
                int[] toProcess = pq.poll();
                processQueue.add(new int[]{toProcess[1], toProcess[2]});
            }
            if (processQueue.isEmpty()) {
                t = pq.peek()[0];
                continue;
            }
            int[] processed = processQueue.poll();
            ret.add(processed[1]);
            t += processed[0];
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();

    }
}