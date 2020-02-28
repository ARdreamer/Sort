package 笔试快手;

import java.util.Scanner;

/**
 * 给定一个32位int型正整数，我们定义如下操作，取其十进制各位数字的平方和，并不断重复这个操作。如果某次操作完成后得到的结果是1，则返回true；否则继续执行，直到证明永远不会得到结果为1，返回false
 * input:19
 * <p>
 * output:true
 * <p>
 * 原因：
 * <p>
 * 1^2 + 9^2=82
 * <p>
 * 8^2 + 2^2 = 68
 * <p>
 * 6^2 + 8^2 =  100
 * <p>
 * 1^2 + 0^2 + 0^2 = 1
 * 输入描述:
 * 输入一个m(1<=m<=1000)，表示查询组数。
 * <p>
 * 接下来m行，每一行为一个32位int型正整数。
 * 输出描述:
 * 对于每次查询，如果满足题目描述，则输出"true"，反之输出"false" (不要输出引号)
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 2
 * 19
 * 7
 * 输出
 * 复制
 * true
 * true
 */
public class 计算累计平方和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- > 0){
            int num = sc.nextInt();
            System.out.println(canBe1(num));
        }
    }
    public static boolean canBe1(int num){   //判断数字是否为快乐数
        int temp = num;
        while(true){
            temp = next(temp);
            if (temp == 1) {
                return true;
            }else if (temp == 89) {    //89作为不是快乐数的结点
                return false;
            }
        }
    }
    public static int next(int num){
        int res = 0;
        while (num > 0) {
            res += (num % 10) * (num %10);
            num = num / 10;
        }
        return res;
    }
}
