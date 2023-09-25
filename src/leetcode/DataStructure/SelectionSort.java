package leetcode.DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public List<Integer> selectionSort(List<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(minIdx) > list.get(j))
                    minIdx = j;
            }
            if (minIdx != i)
                Collections.swap(list, minIdx, i);
        }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);

        SelectionSort s = new SelectionSort();
        System.out.println(s.selectionSort(list));
    }
}
