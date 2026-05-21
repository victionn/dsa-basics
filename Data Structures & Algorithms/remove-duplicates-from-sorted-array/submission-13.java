class Solution {
    public int removeDuplicates(int[] nums) {
        int place = 0;
        int unique = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != unique) {
                unique = nums[i];
                nums[place] = unique;
                place ++; 
            }
        }
        return place;
    }
}