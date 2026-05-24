class TimeMap {
    HashMap<String,List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        String[] toAdd = new String[2];
        toAdd[0] = Integer.toString(timestamp);
        toAdd[1] = value;
        map.putIfAbsent(key, new ArrayList<>());
        List<String[]> li = map.get(key);
        li.add(toAdd);
    }
    
    public String get(String key, int timestamp) {
        List<String[]> li = map.get(key);
        int l = 0;
        if (li == null) {
            return "";
        }
        int r = li.size() - 1;
        String[] cand = new String[]{"", ""};
        String result = "";
        while (l <= r) {
            int mid = l + (r - l) / 2;
            cand = li.get(mid);
            if (Integer.parseInt(cand[0]) == timestamp) {
                return cand[1];
            }
            else if (Integer.parseInt(cand[0]) > timestamp) {
                
                r = mid - 1;
            }
            else {
                result = li.get(mid)[1];
                l = mid + 1;
            }
        }
        return result;
    }
}
