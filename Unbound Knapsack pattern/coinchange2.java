// program to find the minimum number of coins needed to generate the given amount of money

public class coinchange2 {
    public static int coinChange_2(int[] coins, int amount, int N, int[][] dp) {
        if (N <= 1) {
            return amount;
        }
        int k = 1;
        for (int i = 1; i < amount + 1; i++) {
            if (i % coins[k] == 0) {
                dp[k][i] = i / coins[k - 1];
            } else {
                dp[k][i] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 3, 4, 5, 6 };
        int amount = 16;
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        System.out.println(coinChange_2(coins, amount, N, dp));
    }
}
