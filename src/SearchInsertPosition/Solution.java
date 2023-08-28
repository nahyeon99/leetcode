package SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target) {
                left = mid + 1;
                result = left;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}