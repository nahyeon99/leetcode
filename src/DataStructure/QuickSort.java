package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

//    public ArrayList<Integer> quickSort(ArrayList<Integer> list) {
//
//        if (list.size() <= 1)
//            return list;
//
//        int pivot = list.get(0);
//
//        ArrayList<Integer> left = new ArrayList<>();
//        ArrayList<Integer> right = new ArrayList<>();
//
//        for (int i = 1; i < list.size(); i++) {
//            if (pivot < list.get(i))
//                right.add(list.get(i));
//            else
//                left.add(list.get(i));
//        }
//
//        ArrayList<Integer> merged = new ArrayList<>();
//        merged.addAll(this.quickSort(left));
//        merged.addAll(Arrays.asList(pivot));
//        merged.addAll(this.quickSort(right));
//
//        return merged;
//    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> list) {

        if (list.size() <= 1)
            return list;

        int pivot = list.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (pivot > list.get(i))
                left.add(list.get(i));
            else
                right.add(list.get(i));
        }

        ArrayList<Integer> merged = new ArrayList<>();

        merged.addAll(this.quickSort(left));
        merged.addAll(Arrays.asList(pivot));
        merged.addAll(this.quickSort(right));

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);

        QuickSort s = new QuickSort();
        System.out.println(s.quickSort(list));
    }
}
