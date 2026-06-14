class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        candidate = strs[0]
        n = len(candidate)
        word = ""
        for i in range(n):
            let = candidate[i]
            for j in range(1, len(strs)):
                if i >= len(strs[j]) or let != strs[j][i]:
                    return word
            word += (let)
        return word


        