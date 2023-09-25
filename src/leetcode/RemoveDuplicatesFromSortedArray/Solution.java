package leetcode.RemoveDuplicatesFromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int lastValue = -101;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastValue) {
                nums[index] = nums[i];
                lastValue = nums[i];
                index++;
            }
        }
        return index;
    }
}