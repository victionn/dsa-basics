class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); //holds sum, and count
        map.put(0, 1);
        int currSum = 0;
        int count = 0;
        for (int i = 0;i < nums.length; i++ ){
            currSum += nums[i];
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }
            System.out.println(currSum);
            map.put(currSum, map.getOrDefault(currSum, 0)  + 1);
        }
        return count;
    }
}