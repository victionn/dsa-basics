class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        arr = []
        if (len(s) == len(t)):
            for letter in s:
                arr.append(letter)
            # arr2 = arr
            print(arr)
            for letter in t:
                if letter in arr:
                    arr.remove(letter)
                # else:
                    # False
            if len(arr) == 0:
                return True
        return False