class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string s = strs[0];
        string ret;
        for(int i = 0; i < s.size(); i++) {
            char cand = s[i];
            for (int j = 1; j < strs.size(); j++) {
                if (i > strs[j].size() - 1 || strs[j][i] != cand) {
                    cout << "hel";
                    return ret;
                }
            }
            ret.push_back(cand);
        }
        return ret;
    }
};