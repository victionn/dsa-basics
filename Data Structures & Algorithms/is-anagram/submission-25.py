class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        sbucket = [0] * 26
        tbucket = [0] * 26
        for i in range(len(s)):
            sbucket[ord(s[i]) - ord('a')] += 1
            tbucket[ord(t[i]) - ord('a')] += 1
        for i in range(len(sbucket)):
            if sbucket[i] != tbucket[i]:
                return False
        return True 