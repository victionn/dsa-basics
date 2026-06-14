class Solution:
    def freqToString(self, strs):
        freq = [0] * 26 
        for i in strs:
            freq[ord(i) - ord('a')] += 1
        ret = ""
        for i in freq:
            ret += "*" + str(i) 
        return ret
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        unique= {}
        for word in strs:
            stamp = self.freqToString(word)
            if stamp in unique:
                unique[stamp].append(word)
            else:
                unique[stamp] = []
                unique[stamp].append(word)
        ret = []
        for key in unique:
            ret.append(unique[key])
        return ret
        
        