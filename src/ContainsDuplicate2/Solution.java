package ContainsDuplicate2;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> hashMap = new HashMap<>(nums.length); // value, index

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (Math.abs(i - hashMap.get(nums[i])) <= k)
                    return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }
}