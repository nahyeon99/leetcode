package leetcode.SearchA2DMatrix;

class Solution {

    /**
     * @return
     * target 존재 시: 1
     * target 이 더 크다: 2
     * target 이 더 작다: 3
     */
    private int searchRow(int[][] matrix, int row, int target) {
        int size = matrix[row].length;

        int minValue = matrix[row][0];
        int maxValue = matrix[row][size - 1];
        if (minValue <= target && target <= maxValue)
            return 1;
        else if (maxValue < target)
            return 2;
        else
            return 3;
    }

    private boolean searchRowValue(int[][] matrix, int row, int target) {

        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int searchRowResult = searchRow(matrix, mid, target);
            if (searchRowResult == 1) {
                return searchRowValue(matrix, mid, target);
            } else if (searchRowResult == 2) { //target 이 더 크다.
                left = mid + 1;
            } else { //target 이 더 작다.
                right = mid - 1;
            }
        }

        return false;
    }
}