package test;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SortDemo {

    public void test01() {
//        List list  =new ArrayList();
//        list.c
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        ListNode a3 = new ListNode(3);
        a2.next = a3;
        ListNode a4 = new ListNode(4);
        a3.next = a4;
        ListNode a5 = new ListNode(5);
        a4.next = a5;

        ListNode newList = reverseList1(a1);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public void test02() {
//        aal.Parent child = new aal.Child();
//        child.method();
//        aal.Child child1 = new aal.Child();
//        child1.method();
//        child1.me();
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8};
//        List<Integer> aa = Arrays.asList(1,3,5,7,9,2,4,6,8,109);
//        Collections.sort(aa);
//        for(Integer i:aa){
//            System.out.println(i);
//        }
        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(i);
//        }
        int i = binSerach(a, 8);
        System.out.println(i);
//        System.out.println(FindGreatestSumOfSubArray(a));
    }

    public void test03() {
        StringBuffer stringBuffer = new StringBuffer().append("1").append("2");
        StringBuilder stringBuilder = new StringBuilder().append("a").append("b");
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);
    }

    @Test
    public void maopao() {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        boolean flag = true;
        for (int i = 0; i < a.length && flag; i++) {
            flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                    flag = true;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void xuanze() {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int t = a[min];
                a[min] = a[i];
                a[i] = t;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void demo1() {
        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        System.out.println(i);
        String str = scanner.nextLine();
        System.out.println(str);
    }

    public void charuyouhua() {
        int[] a = {-1, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            int j;
            for (j = i; j > 0 && t < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = t;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void jiou() {
        int[] a = {1, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            if (isEven(t))
                continue;
            int j;
            for (j = i; j > 0 && isEven(a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = t;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public void charu() {
        int[] a = {-1, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                } else {
//                    break;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        //        int i, j;
//        for (i = 1; i < a.length; i++) {
//            if (a[i] < a[i - 1]) {
//                a[0] = a[i];
//                for (j = i - 1; a[j] > a[0]; j--) {
//                    a[j + 1] = a[j];
//                }
//                a[j + 1] = a[0];
//            }
//        }
//        for (i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }

    }

    @Test
    public void xier() {
        int[] arr = {-1, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int t = arr[i];
                int j;
                for (j = i; j >= h && t < arr[j - h]; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = t;
            }
            h /= 3;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        /**
         *         while (h >= 1) {
         *             for (int i = h; i < N; i++) {
         *                 for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
         *                     swap(nums, j, j - h);
         *                 }
         *             }
         *             h = h / 3;
         *         }
         */
    }

    @Test
    public void heapSort() {
        /*PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.add(10);
        priorityQueue.add(9);
        priorityQueue.add(1);
        priorityQueue.add(2);
        for (Iterator<Integer> it = priorityQueue.iterator(); it.hasNext(); ) {
            Integer iterator = it.next();
            System.out.println(iterator);
        }*/
        int[] a = {Integer.MAX_VALUE, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        int n = a.length - 1;
        for (int i = n / 2; i > 0; i--) {
            sink(a, i, n);
        }
        while (n > 1) {
            swap(n--, 1, a);
            sink(a, 1, n);
        }
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void sink(int[] a, int index, int n) {
        while (2 * index <= n) {
            int j = 2 * index;
            if (j + 1 <= n && a[j] < a[j + 1]) {
                j++;
            }
            if (a[index] > a[j])
                break;
            swap(index, j, a);
            index = j;
        }
    }

    public void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void headAdjust(int[] a, int s, int m) {
        int t, j;
        t = a[s];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && a[j] < a[j + 1])
                j++;
            if (t >= a[j])
                break;
            a[s] = a[j];
            s = j;
        }
        a[s] = t;
    }

    @Test
    public void mergeSort() {
        int[] a = {66, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        mSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void mSort(int[] a, int l, int r) {
        int m;
        if (l >= r) {
            return;
        } else {
            m = (l + r) / 2;//m=l+(r-l)/2
            mSort(a, l, m);
            mSort(a, m + 1, r);
            if (a[m] > a[m + 1])
                merge(a, l, m, r);
        }
    }

    public void merge(int[] a, int l, int m, int r) {
        int[] b = new int[r - l + 1];
//        for (int i = l; i <= r; i++) {
//            b[i - l] = a[i];
//        }
        System.arraycopy(a, l, b, 0, r - l + 1);

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                a[k] = b[j - l];
                j++;
            } else if (j > r) {
                a[k] = b[i - l];
                i++;
            } else if (b[i - l] <= b[j - l]) {
                a[k] = b[i - l];
                i++;
            } else {
                a[k] = b[j - l];
                j++;
            }
        }
    }

    public int binSerach(int[] a, int key) {
        int low = 0;
        int high = a.length;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //1-2-3-4-5
    //2-1-3-4-5
    //3-2-1-4-5
    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy.next;
        ListNode curNode = preNode.next;
        while (curNode != null) {
            preNode.next = curNode.next;
            curNode.next = dummy.next;
            dummy.next = curNode;
            curNode = preNode.next;
        }
        return dummy.next;
    }

    /**
     * 1 2 3 4 5 6 7
     * <p>
     * 到了6就返回，当前node是6
     * 6.next(7).next(null)也就是 7.next = 6, 6.next = null
     * return 6，5.next(6).next(null) = 5,也就是 6.next = 5, 5.next = null
     *
     * @param head
     * @return
     */
    public ListNode reverseListDiGui(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = reverseListDiGui(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i]; //记录当前最大值
            } else {
                curSum += array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    public void map() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            final Map.Entry<Integer, Integer> next = iterator.next();
            next.getValue();
        }
       ArrayList<Integer> list = new ArrayList();
        final List<Integer> collect = list.stream().filter(i -> i > 0).collect(Collectors.toList());
    }
}
