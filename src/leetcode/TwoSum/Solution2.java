package leetcode.TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (valueIndexMap.containsKey(target - nums[i])) {
                return new int[]{valueIndexMap.get(target - nums[i]), i};
            }
            valueIndexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}