package leetcode.DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public List<Integer> bubbleSort(ArrayList<Integer> list) {

        for (int i = list.size() - 1 ; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1))
                    Collections.swap(list, j, j + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);

        BubbleSort bs = new BubbleSort();
        System.out.println(bs.bubbleSort(list));
    }
}
