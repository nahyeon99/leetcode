package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public List<Integer> insertionSort(List<Integer> list) {

        for (int idx1 = 0; idx1 < list.size() - 1; idx1++) {

            for (int idx2 = idx1 + 1; idx2 > 0; idx2--) {
                if (list.get(idx2) < list.get(idx2 - 1)) {
                    Collections.swap(list, idx2, idx2 - 1);
                } else {
                    break;
                }
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

        InsertionSort s = new InsertionSort();
        System.out.println(s.insertionSort(list));
    }
}
