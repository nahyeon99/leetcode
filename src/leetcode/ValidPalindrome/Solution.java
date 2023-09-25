package leetcode.ValidPalindrome;

class Solution {

    private String removeNonAlphanumericCharacters(String s) {

        return s.replaceAll(" ", "")
                .replaceAll("[~!@#$%^&*()_+{}₩`\\[\\]<>,./?\\-:;'\"]", "")
                .toLowerCase();
    }

    private boolean checkValidString(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        s = removeNonAlphanumericCharacters(s);
        return checkValidString(s);
    }
}