/*
defs need a hashmap to count frequency

OUXYZZIO
if(map.contains(i) && map.get(i))


 */

class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String ret = "";
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        //Hash map to count the current window frequency
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        //Left sliding window
        int l = 0;
        int match = 0;
        for (int r = 0; r < s.length(); r++) {
            if (tFreq.containsKey(s.charAt(r))) {
                windowFreq.put(s.charAt(r), windowFreq.getOrDefault(s.charAt(r), 0) + 1);
                if (tFreq.get(s.charAt(r)) == windowFreq.get(s.charAt(r))) {
                    match ++;
                }
            }
            // Shrink left window
            while (match == tFreq.size()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ret = s.substring(l, r + 1);
                }
                char leftChar = s.charAt(l);
                if (windowFreq.containsKey(leftChar)) {
                    if (tFreq.get(leftChar) == windowFreq.get(leftChar)) {
                        match--;
                    }
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                }
                l++;
            }
        }
        return ret;
    }
}
