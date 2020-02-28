package 笔试美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 8192KB；其他语言 532480KB
 * <p>
 * ac 64%
 * 题目描述：
 * <p>
 * 2110年美团外卖火星第3000号配送站点有26名骑手，
 * 分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，
 * 黄家骑士特工B…黄家骑士特工Z，某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，
 * 美团配送调度引擎已经将包裹分配到骑手，并在包裹上粘贴好骑手名称，如RETTEBTAE代表一组流水线包裹共9个，
 * 同时分配给了名字为A B E R T的5名骑手。请在不打乱流水线产出顺序的情况下，
 * 把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。
 * <p>
 * 输入
 * 输入数据只有一行，为一个字符串(不包含引号)，长度不超过1000，只包含大写字母'A'到'Z'，字符之间无空格。
 * <p>
 * 输出
 * 输出每个分割成片段的包裹组的长度，每个长度之间通过空格隔开
 * <p>
 * <p>
 * 样例输入
 * MPMPCPMCMDEFEGDEHINHKLIN
 * <p>
 * MPMPCPMCM DEFEGDE HINHKLIN
 * mpc       defg    hinki
 * 样例输出
 * 9 7 8
 */
public class 美团骑手包裹区间分组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            map.put(line.charAt(i), i);
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            count = Math.max(count, map.get(c));
            if (i == count) {
                if (count == line.length() - 1) {
                    System.out.println(count + 1 - index);
                    break;
                } else {
                    System.out.println(count + 1 - index + "");
                    index = count + 1;
                }
            }
        }
    }
}
