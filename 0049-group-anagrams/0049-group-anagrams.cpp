class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> kv_map;
        for (string& s : strs) {
            string sig = s;
            sort(s.begin(), s.end());
            kv_map[s].push_back(sig);
        }
        vector<vector<string>> res;
        for (auto& kv : kv_map) {
            res.push_back(kv.second);
        }
        return res;
    }
};