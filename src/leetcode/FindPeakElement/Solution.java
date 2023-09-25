package leetcode.FindPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1)
            return 0;

        int left = 0, right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        while (left <= right) {
            if (nums[left] > max) {
                maxIdx = left;
                max = nums[left];
            }
            if (nums[right] > max) {
                maxIdx = right;
                max = nums[right];
            }
            left++;
            right--;
        }
        return maxIdx;
    }
}