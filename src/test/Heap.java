package test;

public class Heap {
    private int count;
    private int cap;
    private int[] data;

    public Heap(int cap) {
        this.cap = cap;
        data = new int[cap + 1];
        count = 0;
    }

    /**
     * 通过最后一个叶子节点去获取最后一个有孩子节点的下标
     * 然后从那个下标开始构建最大堆
     * 也就是向上比较
     */
    Heap(int[] a) {
        cap = a.length;
        data = new int[a.length + 1];
        for (int i = 1; i < data.length; i++) {
            data[i] = a[i - 1];
        }
        count = a.length;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int getCount() {
        return count;
    }

    public void insert(int num) {
        if (count < cap) {
            data[count + 1] = num;
            count++;
            shiftUp(count);
        }
    }

    public void shiftUp(int index) {
        while (index > 1 && data[index] > data[index / 2]) {
            int t = data[index];
            data[index] = data[index / 2];
            data[index / 2] = t;
            index /= 2;
        }
    }

    public void shiftDown(int index) {
        while (index * 2 <= count) {
            int j = 2 * index;
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j = j + 1;
            }
            if (data[index] > data[j])
                break;
            int t = data[j];
            data[j] = data[index];
            data[index] = t;
            index = j;
        }
    }

    //把最后一个放到第一个然后向下移动
    public int yichu() {
        int num = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return num;
    }

    //原地排序,从0开始,结果从小到大
    public void heapSortYuanDi(int[] a) {
        //构建堆，第一个非叶子结点开始
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            shiftDownYuanDi(a, a.length, i);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            shiftDownYuanDi(a, i, 0);
        }
    }

    public void shiftDownYuanDi(int[] a, int n, int index) {
        while (index * 2 + 1 < n) {
            int j = 2 * index + 1;
            if (j + 1 < n && a[j + 1] > a[j]) {
                j = j + 1;
            }
            if (a[index] > a[j])
                break;
            int t = a[j];
            a[j] = a[index];
            a[index] = t;
            index = j;
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        Heap heap = new Heap(100);
        for (int i = 1; i < a.length; i++) {
            heap.insert(a[i]);
        }
        for (int i = 1; i < a.length; i++) {
            System.out.println(heap.yichu());
        }
    }
}
