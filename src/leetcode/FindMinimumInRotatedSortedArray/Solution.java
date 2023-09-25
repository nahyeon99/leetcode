package leetcode.FindMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int min = (left + right) / 2;

            if (nums[min] < nums[right])
                right = min;
            else
                left = min + 1;
        }

        return nums[left];
    }
}