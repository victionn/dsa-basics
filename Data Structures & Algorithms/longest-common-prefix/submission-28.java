class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        int prefix = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            while(prefix > strs[i].length() || !first.substring(0, prefix).equals(strs[i].substring(0,prefix))) {
                prefix--;
            }
        }
        return strs[0].substring(0,prefix);
    }

}