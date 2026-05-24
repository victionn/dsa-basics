/*
if nums[target] > nums[right] , rotation is in here
else 
if 

*/


class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // find pivot first
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        int piv = l;
        l = 0;
        r = nums.length - 1;
        if (piv > 0) {
            if (nums[0] > target) {
            l = piv;
            }
            else {
                System.out.print("g");
                r = piv - 1;
            }
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
