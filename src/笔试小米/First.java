package 笔试小米;

import java.util.Scanner;

/**
 * 模仿2048游戏
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 《2048》是一款热门的数字游戏。游戏中，每个方块上的数字都有2的幂，数字方块会根据指令整体进行上下左右移动，如果两个数字相同的方块在移动中碰撞，他们就会合成一个新的方块。例如下图为4*4格子的游戏，0表示格子为空，图a为移动前格子中的数字，图b为图a左移后的结果:
 * <p>
 * 0 0 2 4
 * 0 2 2 2
 * 0 4 2 2
 * 8 8 2 2
 * 图a
 * 2 4 0 0
 * 4 2 0 0
 * 4 4 0 0
 * 16 4 0 0
 * 图b
 * 问，给定n*m的矩阵M，0表示空格子，非0整数表示待移动的数字，按照2048的移动规则，输出进行左移操作后的矩阵结果。
 * <p>
 * 输入
 * 输入n行数据
 * <p>
 * 第1行为矩阵行数
 * <p>
 * 第2行到第n行为矩阵每行数据，m个数据用空格隔开
 * <p>
 * 输出
 * 输出左移后的矩阵，单行元素用空格隔开，换行处无空格
 * <p>
 * <p>
 * 样例输入
 * 4
 * 0 0 2 4
 * 0 2 2 2
 * 0 4 2 2
 * 8 8 2 2
 * 样例输出
 * 2 4 0 0
 * 4 2 0 0
 * 4 4 0 0
 * 16 4 0 0
 */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int _input_size = 0;
        _input_size = Integer.parseInt(sc.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = sc.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }
        int[][] ints = new int[_input_size][_input_size];
        int i = 0, j = 0;
        for (String s : _input) {
            for (String ss : s.split(" ")) {
                ints[i][j++] = Integer.valueOf(ss);
            }
            j = 0;
            i++;
        }
        solution(ints);
        for (int k = 0; k < ints.length; k++) {
            for (int l = 0; l < ints[k].length; l++) {
                System.out.print(ints[k][l] + " ");
            }
            System.out.println();
        }
    }

    static void solution(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            move(input);
            for (int j = 0; j < input[i].length - 1; j++) {
                if (input[i][0] != 0) {
                    if (input[i][j] == input[i][j + 1]) {
                        input[i][j] += input[i][j];
                        input[i][j + 1] = 0;
                    }
                }
            }
            move(input);
        }
    }

    static void move(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length - 1; j++) {
                int k = j;
                while (k >= 0 && input[i][k] == 0) {
                    input[i][k] = input[i][k + 1];
                    input[i][k + 1] = 0;
                    k--;
                }
            }
        }
    }
}
