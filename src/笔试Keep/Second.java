package 笔试Keep;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        String cost = sc.nextLine();
        String[] dayss = day.split("\\,");
        String[] costss = cost.split("\\,");
        Integer[] days = new Integer[dayss.length];
        Integer[] costs = new Integer[costss.length];
        for (int i = 0; i < dayss.length; i++) {
            days[i] = Integer.valueOf(dayss[i]);
        }
        for (int i = 0; i < costss.length; i++) {
            costs[i] = Integer.valueOf(costss[i]);
        }
        int[] dp = new int[days.length + 1];
        dp[1] = 2;
        for (int i = 2; i <= days.length; i++) {
            if (days[i] > 30) {
//                dp[i] = Math.max(dp[i - 1] + 2,dp[] )
            }
        }
    }
}
