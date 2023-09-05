package DataStructure;

import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {

        if (dataList.size() <= 1)
            return dataList;

        ArrayList<Integer> left;
        ArrayList<Integer> right;

        int mid = dataList.size() / 2;

        left = this.splitFunc(new ArrayList<Integer>(dataList.subList(0, mid)));
        right = this.splitFunc(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));

        return mergeSort(left, right);
    }

    private ArrayList<Integer> mergeSort(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {

        ArrayList<Integer> mergedList = new ArrayList<>();
        int left = 0, right = 0;

        // CASE1: left, right 모두 있는 경우
        while (leftList.size() > left && rightList.size() > right) {
            if (leftList.get(left) > rightList.get(right)) {
                mergedList.add(rightList.get(right));
                right++;
            } else {
                mergedList.add(leftList.get(left));
                left++;
            }
        }

        // CASE2: left 만 있는 경우
        while (leftList.size() > left) {
            mergedList.add(leftList.get(left));
            left++;
        }

        // CASE3: right 만 있는 경우
        while (rightList.size() > right) {
            mergedList.add(rightList.get(right));
            right++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);

        MergeSort ms = new MergeSort();
        System.out.println(ms.splitFunc(list));
    }
}
