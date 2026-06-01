class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> curr) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        dfs(nums, index + 1, curr);
        curr.remove(Integer.valueOf(nums[index]));
        dfs(nums, index + 1, curr);
    }
}
