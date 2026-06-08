/* 


hashmap 

IXL

I: -1

X: -10

C: -100
*/

class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> sub;
        unordered_map<char, int> convert;
        sub['I'] = -1;
        sub['X'] = -10;
        sub['C'] = -100;
        convert['X'] = 10;
        convert['I'] = 1;
        convert['V'] = 5;
        convert['L'] = 50;
        convert['C'] = 100;
        convert['D'] = 500;
        convert['M'] = 1000;
        int total = 0;
        int n = s.size();
        bool applied;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && sub.find(s[i]) != sub.end() && !applied){
                char letF = s[i + 1];
                bool mat = false;
                if (s[i] == 'I') {
                    if (letF == 'V' || letF == 'X') {
                        total -= 1;
                        mat = true; 
                    }   
                }
                else if (s[i] == 'X') {
                    if (letF == 'L' || letF == 'C') {
                        total -= 10;
                        mat = true;
                    }
                }
                else if (s[i] == 'C') {
                    if (letF == 'D' || letF == 'M') {
                        total -= 100;
                        mat = true;
                    }
                }
                if (mat != true) {
                    total += convert[s[i]];
                }
                else { 
                    cout << ":";
                    cout << s[i];
                    applied = true;
                }
                continue;
            }
            total += convert[s[i]];
            applied = false;
        }
        
        return total;
    }
};