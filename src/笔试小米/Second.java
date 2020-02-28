package 笔试小米;

import java.util.Arrays;
import java.util.Scanner;
//2 4 6 7
//4 2 7 6

/**
 * 数组移动
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一个数列，每一次移动可以将数列某个数移动到某个位置上，移动多次后，形成新的数列。定义数列中相邻两两之间的差的绝对值为“移动距离”，定义所有移动距离的总和为“总移动距离”。希望计算出最少的移动次数，使得新数列的“总移动距离”最小。 例如原数列为[4,2,7,6]，总移动距离为2+5+1=8。将6移动到7之前，会变成[4,2,6,7]，总移动距离变成2+4+1=7。
 * <p>
 * 需要编写一个函数，输入为一个int数组表示数列内容，输出为一个int数字，表示最小移动次数
 * <p>
 * 输入
 * 第一行输入为数组大小，然后依次输入数组元素，如数组[4, 2, 7, 6]
 * <p>
 * 输出
 * 总移动距离最小的数列之一为[2,4,6,7]
 * <p>
 * 最少移动次数：2
 * <p>
 * <p>
 * 样例输入
 * 4
 * 4
 * 2
 * 7
 * 6
 * 样例输出
 * 2
 */
public class Second {
    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        Pair[] pairs = new Pair[_arr_size];
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
            pairs[_arr_i] = new Pair(_arr_item, _arr_i);
        }
        Arrays.sort(pairs, (p1, p2) -> (int) (p1.key - p2.key));
        int count = 1;
        int i = 0;
        while (i < _arr_size - 1) {
            if (pairs[i].value <= pairs[i + 1].value) {
                count++;
            }
            i++;
        }
        System.out.println(count);

//        res = solution(_arr);
//        System.out.println(String.valueOf(res));

    }

    static int solution(int[] arr) {
        int[] num = new int[arr.length];
        System.arraycopy(arr, 0, num, 0, arr.length);
        Arrays.sort(num);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num[i] > arr[i])
                count++;
        }
        return count;
    }
}
