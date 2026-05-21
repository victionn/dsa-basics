class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();
        int max = 0;
        int curr = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            while (map.contains(c)) {
                map.remove(s.charAt(l));
                l++;
                curr--;
            }
            map.add(c);
            curr++;
            max = Math.max(curr, max);
        }
        return max;
    }
}
