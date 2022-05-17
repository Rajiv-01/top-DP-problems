// program to find the longest common subsequence of two strings return length, means characters are in same sequence even they are not in
// contigous order
public class LongestCommonSequence {

    public static int LCS(String str1, String str2, int len1, int len2, int[][] dp) {

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];

        // bottom up approach using memoization

        // if (len1 == 0 || len2 == 0) {
        // return 0;
        // }
        // if (dp[len1][len2] != -1)
        // return dp[len1][len2];
        // if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
        // dp[len1][len2] = 1 + LCS(str1, str2, len1 - 1, len2 - 1, dp);
        // } else {
        // dp[len1][len2] = Math.max(LCS(str1, str2, len1 - 1, len2, dp), LCS(str1,
        // str2, len1, len2 - 1, dp));

        // }
        // return dp[len1][len2];
    }
    // recursive approach

    // public static int LCS(String str1, String str2, int len1, int len2) {
    // if (len1 == 0 || len2 == 0) {
    // return 0;
    // }
    // if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
    // return 1 + LCS(str1, str2, len1 - 1, len2 - 1);
    // } else {
    // return Math.max(LCS(str1, str2, len1 - 1, len2), LCS(str1, str2, len1, len2 -
    // 1));

    // }
    // }

    public static void main(String[] args) {
        String s1 = "abddef";
        String s2 = "abcidefg";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // for (int i = 0; i < s1.length() + 1; i++) {
        // for (int j = 0; j < s2.length() + 1; j++) {
        // dp[i][j] = -1;
        // }
        // }
        System.out.println(LCS(s1, s2, s1.length(), s2.length(), dp));
    }
}
