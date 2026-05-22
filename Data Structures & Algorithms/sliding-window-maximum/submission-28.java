/* 
1 2 1 0 4 2 6




*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> li = new ArrayList<>(); 
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deck.isEmpty() && deck.peekLast() < nums[i]) {
                deck.pollLast();
            }
            deck.addLast(nums[i]);
        }
        li.add(deck.peekFirst());
        int l = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[l] == deck.peekFirst()) {
                deck.pollFirst();
            }
            while (!deck.isEmpty() && deck.peekLast() < nums[i]) {
                deck.pollLast();
            }
            deck.add(nums[i]);
            l++;
            li.add(deck.peekFirst());
        }
        int[] ret = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            ret[i] = li.get(i);
        }
        return ret;
    }
}
