
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> toMatch = new HashMap<>();
        HashMap<Character,Integer> currMatch = new HashMap<>();
        if (s2.length() < s1.length()) {
            return false;
        }
        for (char c : s1.toCharArray()) {
            toMatch.put(c,toMatch.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            currMatch.put(s2.charAt(i), currMatch.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (isValid(toMatch, currMatch)) {
            return true;
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            currMatch.put(s2.charAt(r), currMatch.getOrDefault(s2.charAt(r),0) + 1);
            currMatch.put(s2.charAt(l), currMatch.get(s2.charAt(l)) - 1);
            if (isValid(toMatch, currMatch)) {
                return true;
            }
            l++;
        }
        return false;
    }  

    public boolean isValid(HashMap<Character,Integer> m1, HashMap<Character, Integer> m2) {
        for (char c : m1.keySet()) {
            if (m2.containsKey(c) && m1.get(c) == m2.get(c)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
