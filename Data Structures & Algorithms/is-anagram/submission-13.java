class Solution {
    public boolean isAnagram(String s, String t) {
        int[] bucket = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a'] ++;
            bucket[t.charAt(i) - 'a'] --;
        }
        for (int num : bucket) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
