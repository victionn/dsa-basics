class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        for (string s : strs) {
            vector<int> freq(26,0);
            for (char c : s) {
                freq[c - 'a']++;
            }
            string count;
            for (int c : freq) {
                count.append(to_string(c));
                count.append("#");
            }
            mp[count].push_back(s);
        }
        vector<vector<string>> res;
        for (auto&a : mp) {
            res.push_back(a.second);
        }
        return res;

    }
};