class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        my_set = set(nums)
        if len(my_set) != len(nums):
            return True
        return False