package leetcode.TwoSum;

import java.util.Arrays;

/**
 * HashTable 사용
 */
class Solution {

    class Slot { // address: 원소 value % 배열 길이
        int key; // 원본 배열 원소 index
        int value; // 원본 배열 원소 값
        boolean isCheck; // 같은 원소일 경우 사용 여부 체크 flag

        public Slot(int key, int value) {
            this.key = key;
            this.value = value;
            this.isCheck = false;
        }
    }

    private Slot[] hashTable;

    private int getIdx(int targetValue) {
        int address = Math.abs(targetValue) % hashTable.length;

        if (hashTable[address] != null) {
            if (hashTable[address].value == targetValue) {
                if (!hashTable[address].isCheck) {
                    hashTable[address].isCheck = true;
                    return hashTable[address].key;
                }
            }
            int currAddress = (address + 1 >= hashTable.length) ? 0 : address + 1;
            while (hashTable[currAddress] != null) {
                if (hashTable[currAddress].value == targetValue && !hashTable[currAddress].isCheck) {
                    hashTable[currAddress].isCheck = true;
                    return hashTable[currAddress].key;
                }
                else {
                    currAddress++;
                    if (currAddress >= hashTable.length)
                        currAddress = 0;
                }
            }
        }
        throw new RuntimeException("Somethings wrong...");
    }

    public int[] twoSum(int[] nums, int target) {

        hashTable = new Slot[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int address = Math.abs(nums[i]) % nums.length;

            if (hashTable[address] != null) {

                int currAddress = (address + 1 >= nums.length) ? 0 : address + 1;

                while (hashTable[currAddress] != null) {
                    currAddress++;

                    if (currAddress >= hashTable.length)
                        currAddress = 0;
                }
                hashTable[currAddress] = new Slot(i, nums[i]);
            } else {
                hashTable[address] = new Slot(i, nums[i]);
            }
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int sum = Integer.MAX_VALUE;
        while (left < right) {
            sum = nums[left] + nums[right];

            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        int leftIdx = getIdx(nums[left]);
        int rightIdx = getIdx(nums[right]);

        return new int[]{leftIdx, rightIdx};
    }
}