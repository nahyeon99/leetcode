package MajorityElement;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();

        int value = 0;
        for (int num : nums) {

            if (!numCount.containsKey(num)) {
                numCount.put(num, 1);
            } else {
                numCount.put(num, numCount.get(num) + 1);
            }
            if (numCount.get(num) > nums.length / 2) {
                value = num;
                break;
            }
        }
        return value;
    }
}