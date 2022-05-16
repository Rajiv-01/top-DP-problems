// program to find the total number of way we can generate the amount given the denominations and the amount

public class coinchange1 {
    public static int coinChange(int[] coins, int amount, int N, int[][] dp) {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                // when coin array is zero and sum > 0 number of ways==0
                // when coin array is zero and sum == 0 number of ways==1 {null case}
                // when sum == 0 number of ways==1

                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 3 };
        int amount = 6;
        int N = coins.length;
        int[][] map = new int[N + 1][amount + 1];
        System.out.println(coinChange(coins, amount, N, map));

    }
}
