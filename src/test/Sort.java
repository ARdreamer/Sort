package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void maopao(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = true;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                    flag = false;
                }
            }
            if (flag == true)
                break;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int i, int j) {
        System.out.println("swap" + a[i] + " " + a[j]);
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    public static void main(String[] args) {

        Integer[] a = {5, 4, 2, 3, 8, 1, 3, 5, 7, 9, 2, 4, 6, 8, 11, 12, 2};
//        maopao(a);
//        Comparator cmp = ;
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int arr : a) {
            System.out.print(arr + " ");
        }
    }
}

class Sort1Demo implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 02 - 01;
    }
}