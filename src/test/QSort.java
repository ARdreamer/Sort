package test;

import java.util.Scanner;

public class QSort {
    public static void quickSort(int[] a) {
        quSort(a, 0, a.length - 1);
    }

    private static void quSort(int[] a, int low, int high) {
        int key;
        if (low < high) {
            key = getIndex(a, low, high);
            quSort(a, low, key - 1);
            quSort(a, key + 1, high);
        }
}

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

//    private static int partition(int[] a, int low, int high) {
//        int key;
//        key = a[low];
//        while (low < high) {
//            while (low < high && a[high] >= key) {
//                high--;
//            }
//            int t = a[low];
//            a[low] = a[high];
//            a[high] = t;
//            while (low < high && a[low] <= key) {
//                low++;
//            }
//            int tmp = a[low];
//            a[low] = a[high];
//            a[high] = tmp;
//        }
//        return low;
//    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        System.out.println(i);
//        String str = scanner.nextLine();
//        String str2 = scanner.nextLine();
//        System.out.println(str);
//        System.out.println(str2);

        int[] a = {66, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
