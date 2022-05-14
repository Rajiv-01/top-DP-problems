class subset {

    public static boolean isSubsetSum(int[] array, int Sum, int N, boolean[][] dp) {
        if (dp[Sum][N] == true) {
            return true;
        }
        if (Sum == 0)
            return true;
        if (N <= 0) {
            return false;
        }
        if (array[N - 1] <= Sum) {
            dp[Sum][N] = (isSubsetSum(array, Sum - array[N - 1], N - 1, dp) || isSubsetSum(array, Sum, N - 1, dp));
        } else {
            dp[Sum][N] = isSubsetSum(array, Sum, N - 1, dp);
        }
        return dp[Sum][N];
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 4, 2 };
        int Sum = 1;
        boolean[][] dp = new boolean[Sum + 1][array.length + 1];
        System.out.println(isSubsetSum(array, Sum, array.length, dp));
    }
}

// for bottom up tabular method we will create table dp[Sum+1][N+1] and
// then we will initialize the table first row and first column then we replace
// the function call with table[i-1][j-1]

// for i in range(Sum+1):
// for j in range(N+1):
// if(i==0){
// table[i][j] = true;
// if(j==0){
// table[i][j]= false;
// if (array[N - 1] <= Sum) {
// table[Sum][N]=table[Sum-array[N-1]][N-1] || table[Sum][N-1];
// }
// else{
// table[Sum][N]=table[Sum][N-1];
// }
// return table[Sum][N];
//