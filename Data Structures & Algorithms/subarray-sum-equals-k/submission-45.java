class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        map.put(0,1);
        int counter = 0;
        for (int num : nums) {
            currSum += num;
            if (map.containsKey(currSum - k)) {
                counter += map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return counter;
    }
}