class Solution {
    public void rotate(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        int curr;
        int prev = nums[0];
        int i = 0;
        while (seen.size() != nums.length) {
            i = (i + k) % nums.length;
            if (seen.add(i) == false) {
                i ++;
                prev = nums[i];
                continue;
            }
            curr = nums[i];
            nums[i] = prev;
            prev = curr;

        }
    }


    
}