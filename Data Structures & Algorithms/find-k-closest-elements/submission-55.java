/* 
Fixed size window, calculate the difference of the two, then slide until the value is equal or more


*/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int currWindow = 0;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            currWindow += Math.abs(x - arr[i]);
        }
        int l = 0;
        for (int r = k; r < arr.length; r++) {
            if (arr[r] == arr[r-1]) {
                l++;
                continue;
            }
            if (currWindow <= currWindow + Math.abs((x - arr[r])) - Math.abs((x - arr[l]))) {
                for(int i = l; i < r; i++) {
                    ret.add(arr[i]);
                }
                return ret;
            }
            currWindow += Math.abs(x- arr[r]) - Math.abs(x- arr[l]);
            l++;
        }
        for(int i = l; i < arr.length; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
}