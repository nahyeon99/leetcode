package leetcode.SearchInRotatedSortedArray;

class Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) { // left 가 정렬된 경우

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right 이 정렬된 경우
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}