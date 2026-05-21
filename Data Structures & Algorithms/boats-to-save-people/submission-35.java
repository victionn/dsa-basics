class Solution {

    public int numRescueBoats(int[] people, int limit) {
        int[] bucket = new int[limit + 1];
        int counter = 0;
        for (int num : people) {
            bucket[num] ++;
        }//1 2 2 3 3
        int l = 0;
        int r = bucket.length - 1;
        while (l < r) { 
            if (bucket[l] == 0) {
                l++;
                continue;
            }
            if (bucket[r] == 0) {
                r--;
                continue;
            }

            if (l + r > limit) {
                bucket[r] = bucket[r] - 1;
                counter++;
                continue;
            }
            bucket[r] = bucket[r] - 1;
            bucket[l] = bucket[l] - 1;
            counter ++;
        }
        while (bucket[l] != 0) {
            if (l * 2 <= limit && bucket[l] > 1) {
                bucket[l] -= 2;
                counter += 1;
                continue;
            }
            bucket[l] = bucket[l] - 1;
            counter++;
        }
        return counter;
    }
}