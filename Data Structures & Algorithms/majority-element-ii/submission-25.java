class Solution {
    //5,2,3,3
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if (freqMap.size() > 2) {
                for (int k : new ArrayList<>(freqMap.keySet())) {
                    if (freqMap.get(k) == 1) {
                        freqMap.remove(k);
                    }
                    else {
                        freqMap.put(k, freqMap.get(k) - 1);
                    }
                }
            }
        }   
        List<Integer> li = new ArrayList<>();
        for (int i : freqMap.keySet()) {
            int counter = 0;
            for (int j : nums) {
                if (i == j) {
                    counter ++;
                }
            }
            if (counter > nums.length / 3) {
                li.add(i);
            }
        }
        return li;

    }
}