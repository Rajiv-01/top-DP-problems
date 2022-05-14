// program to find the minimum difference between the sum of two subsets in array
// it is just an optimized version of the subsetWithDiff method
public class minPartitionDiff {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 5, 3, 3, 6, 4 };
        int len = array.length;
        int total = 0;
        for (int i : array) {
            total += i;
        }

        // after getting the formula as deduced in the video we get
        // total-2*subSum1 , where subSum1 is the first subset sum so to minimize this
        // whole expression, we need to
        // maximize the subSum1, which can be computed with the help of knapsack0_1 with
        // total weight as halfcapacity
        // will give wight array as same of array

        int halfcapacity = total / 2;
        int[][] dp = new int[len + 1][halfcapacity + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < halfcapacity + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int sub1Val = knapsack.knapsack0_1(array, array, halfcapacity, len, dp);

        System.out.println(total - 2 * sub1Val);

    }
}
