// program to cut the rod in a way so that the prize get maximum value and the length of the rod is equal to the capacity
// provided and thus return the maximum value

public class rodCutting {
    public static int rodCut(int[] lengths, int[] price, int capacity, int[][] dp, int N) {
        if (capacity == 0) {
            return 0;
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (lengths[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - lengths[i - 1]]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[N][capacity];
    }

    public static void main(String[] args) {
        int[] lengths = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int capacity = 8;
        int N = lengths.length;
        int[][] dp = new int[N + 1][capacity + 1];
        System.out.println(rodCut(lengths, price, capacity, dp, N));
    }
}
