
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] bucket = new int[26];
        int[] bucket2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            bucket[s1.charAt(i) - 'a']++;
            bucket2[s2.charAt(i) - 'a']++;
        }
        int match = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == bucket2[i]) {
                match++;
            }
        }
        int l = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            if (match == 26) {
                return true;
            }
            if (bucket[s2.charAt(i) - 'a'] == bucket2[s2.charAt(i) - 'a']) {
                match--;
            }
            if (bucket[s2.charAt(i) - 'a'] - 1 == bucket2[s2.charAt(i) - 'a']) {
                System.out.println("g");
                match++;
            }
            bucket2[s2.charAt(i) - 'a']++;
            if (bucket[s2.charAt(l) - 'a'] == bucket2[s2.charAt(l) - 'a']) {
                match--;
            }
            if (bucket[s2.charAt(l) - 'a'] + 1 == bucket2[s2.charAt(l) - 'a']) {
                System.out.println("g");
                match++;
            }            
            bucket2[s2.charAt(l) - 'a']--;
            l++;
        }
        return match == 26 ? true : false;
    }
}
