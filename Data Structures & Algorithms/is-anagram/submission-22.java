class Solution {
    public boolean isAnagram(String s, String t) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) { 
            bucket[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            bucket[c - 'a'] --;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;


    }
}
