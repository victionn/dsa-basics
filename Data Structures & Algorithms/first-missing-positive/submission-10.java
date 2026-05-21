class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int counter = 1;
        while (true) {
            if (!set.contains(counter)) {
                break;
            }
            counter ++;
        }
        return counter;
         
    }
}