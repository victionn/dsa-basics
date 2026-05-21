class Solution {
    public boolean isPalindrome(String s) {
        String se = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0;
        int r = se.length() - 1;
        while (l < r) {
            if (se.charAt(l) != se.charAt(r)) {
                return false;
            }
            l ++;
            r--;
        }
        return true;
        
    }
}
