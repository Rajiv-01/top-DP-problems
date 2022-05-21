// program to find the longest repeating subsequence it means if we choose one subsequence then
// we have to choose same subsequence with different characters 
// means to find length of string which is repeating itself
public class longestRepeatingSubSeq {
    public static int longRepSeq(String str, int len, int[][] dp) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str.charAt(i) == str.charAt(j) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len][len];
    }

    public static void main(String[] args) {
        String str = "aabbcbdd";
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        System.out.println(longRepSeq(str, str.length(), dp));

    }
}
