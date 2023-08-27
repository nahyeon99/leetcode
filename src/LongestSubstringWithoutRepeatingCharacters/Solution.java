package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private boolean findWindow(String s, int windowSize) {

        Map<Character, Integer> windowCharTable = new HashMap<>();
        int repeatCount = 0;

        for (int i = 0; i < windowSize; i++) {

            char charAt = s.charAt(i);

            if (windowCharTable.containsKey(charAt)) {
                Integer cnt = windowCharTable.get(charAt);
                windowCharTable.put(charAt, cnt + 1);
                repeatCount = repeatCount + 1;
            } else {
                windowCharTable.put(charAt, 1);
            }
        }

        if (repeatCount == 0)
            return true;

        for (int i = windowSize; i < s.length(); i++) {


            char removeChar = s.charAt(i - windowSize);
            char insertChar = s.charAt(i);

            Integer removeCharCnt = windowCharTable.get(removeChar);

            if (removeCharCnt > 1) {
                repeatCount = repeatCount - 1;
                windowCharTable.put(removeChar, removeCharCnt - 1);
            } else {
                windowCharTable.remove(removeChar);
            }

            if (windowCharTable.containsKey(insertChar)) {
                repeatCount = repeatCount + 1;
                windowCharTable.put(insertChar, windowCharTable.get(insertChar) + 1);
            } else {
                windowCharTable.put(insertChar, 1);

                if (repeatCount == 0)
                    return true;
            }
        }
        return false;
    }

    public int lengthOfLongestSubstring(String s) {

        int left = 1;
        int right = s.length();
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (findWindow(s, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}