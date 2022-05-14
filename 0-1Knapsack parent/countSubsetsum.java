public class countSubsetsum {

    public static int countsub(int[] array, int Sum, int len, int[][] dp) {
        if (dp[Sum][len] > 0) {
            return dp[Sum][len];
        }
        if (Sum == 0) {
            return 1;
        }
        if (len <= 0) {
            return 0;
        }
        if (array[len - 1] <= Sum) {
            dp[Sum][len] = countsub(array, Sum - array[len - 1], len - 1, dp) + countsub(array, Sum, len - 1, dp);
        } else {
            dp[Sum][len] = countsub(array, Sum, len - 1, dp);
        }
        return dp[Sum][len];
    }

    public static void main(String[] args) {
        int[] array = new int[] { 2, 2, 2, 1 };
        int Sum = 3;
        int len = array.length;
        int[][] dp = new int[Sum + 1][len + 1];
        System.out.println(countsub(array, Sum, len, dp));
    }
}
