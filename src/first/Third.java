package first;

/**
 * 有一排正数，玩家A和玩家B都可以看到。
 * 每位玩家在拿走数字的时候，都只能从最左和最右的数中选择一个。
 * 玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
 * 两人都力争自己拿到的数的总和比对方多。请返回最后获胜者的分数。
 * <p>
 * 例如：
 * 5,2,3,4
 * 玩家A先拿，当前他只能拿走5或者4。
 * 如果玩家A拿走5，那么剩下2，3，4。轮到玩家B，此时玩家B可以选择2或4中的一个，…
 * 如果玩家A拿走4，那么剩下5，2，3。轮到玩家B，此时玩家B可以选择5或3中的一个，…
 */
public class Third {
    public static int win1(int[] a) {
        return Math.max(f(a, 0, a.length - 1), s(a, 0, a.length - 1));
    }

    public static int f(int[] a, int i, int j) {
        if (i == j)
            return a[i];
        return Math.max(a[i] + s(a, i + 1, j), a[j] + s(a, i, j - 1));
    }

    public static int s(int[] a, int i, int j) {
        if (i == j)
            return 0;
        return Math.min(f(a, i + 1, j), f(a, i, j - 1));
    }

    public static void main(String[] args) {
//        int[] a = {1,3,5,7,9,2,4,6,8,10};
//        int[] a = {1, 2, 3, 4, 5};
        int[] a = {5, 2, 3, 4};
        System.out.println(win1(a));
    }
}
