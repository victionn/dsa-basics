class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int target = - nums[i];
            while (l < r) { 
                if (nums[l] + nums[r] == target) {
                    System.out.println(i);
                    li.add(Arrays.asList(-target, nums[l], nums[r]));
                    while (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r > 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
                else if (nums[l] + nums[r] > target) {
                    r--;
                }
                else {
                    l ++;
                }
            }
        }
        return li;

    }
}
