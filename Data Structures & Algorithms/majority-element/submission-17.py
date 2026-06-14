class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        cand = nums[0]
        count = 0
        for i in nums:
            if cand == i:
                count += 1
            else:
                count -= 1
            if count == 0:
                cand = i
                count = 1
        return cand
        