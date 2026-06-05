class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        vector<int> bucket1(26);
        vector<int> bucket2(26);
        for (int i = 0; i < s.size(); i++) {
            bucket1[s[i] - 'a'] ++;
            bucket2[t[i] - 'a'] ++;
        }
        for (int i = 0; i < bucket1.size(); i++) {
            if (bucket1[i] != bucket2[i]) {
                return false;
            }
        }
        return true;

    }
};