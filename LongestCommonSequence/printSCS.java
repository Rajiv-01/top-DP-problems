// program to print the shortestCommonSuperSequence between two strings
// we take help of the lcs table drawn before then for common elements we write it once but
// for uncommon elements we have to write it twice 
public class printSCS {
    public static void printSuperSeq(String str1, String str2, int len1, int len2, int[][] dp) {
        StringBuilder result = new StringBuilder();
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
        int i = len1;
        int j = len2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {

                result.append(str1.charAt(i - 1));
                i--;
            } else {

                result.append(str2.charAt(j - 1));

                j--;
            }
        }
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }
        System.out.println(result.reverse().toString());

    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "dabcd";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        printSuperSeq(s1, s2, s1.length(), s2.length(), dp);
    }
}