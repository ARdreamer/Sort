package leetcode;

public class T {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int n = nums.length;
        int[][] dp = new int[n][W + 1];
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else if(nums[0]!=0){
            dp[0][0]=1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
//        System.out.println("0 1 2 3 4\n");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= W; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[n - 1][W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        new T().findTargetSumWays(nums, 3);
    }
}
