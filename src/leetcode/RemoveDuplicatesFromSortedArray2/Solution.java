package leetcode.RemoveDuplicatesFromSortedArray2;

class Solution {
    public int removeDuplicates(int[] nums) {
        int lastValue = 100001;
        boolean checkTwice = false;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastValue) {
                lastValue = nums[i];
                checkTwice = false;
                nums[index] = nums[i];
                index++;
            } else if(!checkTwice) {
                nums[index] = nums[i];
                index++;
                checkTwice = true;
            }
        }
        return index;
    }
}