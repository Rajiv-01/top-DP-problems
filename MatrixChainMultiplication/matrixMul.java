// program to find the minimum cost of matrix multiplication we can get while adjusting the 
// order of matrices to be multiplied 
// single array  is given in which matrix  A has dimension of  arr[i-1] and arr[i] 
public class matrixMul {

    // This is a recursive solution for matrix multiplication.
    /*
     * public static int matrixChainOrder(int[] arr, int i, int j) {
     * if (i == j)
     * return 0;
     * int min = Integer.MAX_VALUE;
     * for (int k = i; k < j; k++) {
     * int count = matrixChainOrder(arr, i, k) + matrixChainOrder(arr, k + 1, j) +
     * arr[i - 1] * arr[k] * arr[j];
     * if (count < min)
     * min = count;
     * }
     * return min;
     * }
     */
    public static int matrixChainOrder(int[] array, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matrixChainOrder(array, i, k, dp) + matrixChainOrder(array, k + 1, j, dp)
                    + array[i - 1] * array[k] * array[j];
            if (count < min) {
                min = count;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int[][] dp = new int[n][n];

        // in this pattern we have two indices left most and right most which could be
        // changed as per question
        // then we take a loop variable k from i to j and then try to divided the
        // problem for i to k and k to j
        // we take the temporary value from each call and then try to calculate the
        // maximum or minimum value
        // out of them
        System.out.println(matrixChainOrder(arr, 1, n - 1, dp));
    }
}
