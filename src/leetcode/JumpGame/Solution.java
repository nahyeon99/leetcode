package leetcode.JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int position = 0;
        for (int i = 0; i <= position; i++) {
            position = Math.max(position, i + nums[i]);
            if (position >= nums.length - 1)
                return true;
        }
        return false;
    }
}