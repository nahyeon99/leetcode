package MinimumSizeSubarraySum;


class Solution {

    private boolean checkSumInWindow(int target, int windowSize, int[] nums) {

        int tempSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < windowSize; i++) {
            tempSum += nums[i];
        }

        if (tempSum >= target)
            return true;

        for (int i = windowSize; i < nums.length; i++) {

            tempSum = tempSum - nums[i - windowSize] + nums[i];
            maxSum = Integer.max(tempSum, maxSum);

            if (maxSum >= target)
                return true;
        }

        return false;
    }

    public int minSubArrayLen(int target, int[] nums) {

        int left = 1;
        int right = nums.length;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (checkSumInWindow(target, mid, nums)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}