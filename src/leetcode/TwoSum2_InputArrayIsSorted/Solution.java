package leetcode.TwoSum2_InputArrayIsSorted;

class Solution {

    private int findTargetValue(int[] numbers, int left, int right,  int targetValue) {

        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] == targetValue)
                return mid;
            if (numbers[mid] < targetValue)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return 1111;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int[] result = null;

        while (left < numbers.length - 1) {
            int targetValue = target - numbers[left];
            int right = findTargetValue(numbers, left + 1, numbers.length - 1, targetValue);


            if(right != 1111) {
                result = new int[]{++left, ++right};
                return result;
            }

            left++;
        }

        throw new IllegalArgumentException("탐색에 실패 했습니다..");
    }
}