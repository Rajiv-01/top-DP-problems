// program to find the minimum number of partition needed such that each substring generated is palindrome
public class palindromePartitioning {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int palindromePart(String str, int i, int j, int[][] dp) {
        int min = str.length() - 1;
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (isPalindrome(str.substring(i, j + 1)))
            return 0;
        for (int k = i; k < j; k++) {
            // so we check both left and right side of the partition and add one(which
            // indicates the partition)
            int left, right;
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = palindromePart(str, i, k, dp);
            }
            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = palindromePart(str, k + 1, j, dp);
            }
            int count = left + right + 1;
            if (count < min) {
                min = count;
            }
        }
        return dp[i][j] = min;

    }

    public static void main(String[] args) {
        String str = "niitina";
        int[][] dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(palindromePart(str, 0, str.length() - 1, dp));

    }
}
