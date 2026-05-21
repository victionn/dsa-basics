class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int l = 0;
        int counter = 0;
        HashMap<Character, Integer> mapFreq = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            mapFreq.put(s.charAt(r), mapFreq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, mapFreq.get(s.charAt(r)));
            //if the string has less letters than k
            while (r - l + 1 - maxFreq > k) {
                System.out.print(mapFreq.get(s.charAt(l)));
                mapFreq.put(s.charAt(l), mapFreq.get(s.charAt(l)) - 1);
                maxFreq = Math.max(maxFreq, mapFreq.get(s.charAt(l)));
                l++;
                counter --;
            }
            counter ++;
        }
        return counter;
    }
}
