class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapTarget = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mapTarget.containsKey(nums[i])) {
                mapTarget.put(target - nums[i], i);
            }
            else {
                return new int[]{mapTarget.get(nums[i]), i};
            }
        }
        return new int[0];
    }
}
