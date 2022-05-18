public class PrintLCS {

    public static String printLCS(String s1, String s2, int len1, int len2, int[][] dp) {
        // this below code is to initialize the dp array
        // using the concept of LCS
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // This below code is to print the LCS
        StringBuilder result = new StringBuilder();
        int i = len1 - 1;
        int j = len2 - 1;
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                result.append(s1.charAt(i));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String s1 = "bcdef";
        String s2 = "abcdef";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // for printing first of all we have to create a 2D array dp and initialize
        // its value with the help of longestCommonSubsequence function which we have
        // created early
        String res = printLCS(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(res);
    }
}
