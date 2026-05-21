class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = nums2.length - 1;
        int place = m + n - 1;
        while (l >= 0 && r >= 0) { 
            if (nums1[l] > nums2[r]) {
                nums1[place] = nums1[l];
                l--;
            }
            else {
                nums1[place] = nums2[r];
                r--;
            }
            place--;
        }
        while (l >= 0) {
            nums1[place] = nums1[l];
            place--;
            l--;
        }
        while (r >= 0) {
            nums1[place] = nums2[r];
            place--;
            r--;
        }

    }
}