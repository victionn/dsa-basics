class Solution {
    public String reorganizeString(String s) {
        //Heap with charcter, and frequency
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a'] ++;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                pq.add(new String[]{Character.toString((char) 'a' + i), Integer.toString(bucket[i])});
            }
        }
        StringBuilder sb = new StringBuilder();
        String[] prev = null;
        /*  */
        while (!pq.isEmpty()) {
            String[] str = pq.poll();
            sb.append(str[0]);
            if (prev != null && Integer.parseInt(prev[1]) > 1) {
                pq.add(new String[]{prev[0], Integer.toString(Integer.parseInt(prev[1]) - 1)});
            } 
            prev = str;
        }
        return sb.toString().length() == s.length() ? sb.toString() : "";

    }
}