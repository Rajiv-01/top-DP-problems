// program to find the longest common palindromin subsequence in a string

public class longestPalindromicSubseq {
    public static void main(String[] args) {
        String str = "baaskdf";
        // what we can do is to get the reverse of the string given and then apply the
        // lcs funtion
        // on these two strings to get the length of longest palindromic subsequence
        String rev = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        System.out.println(LongestCommonSequence.LCS(str, rev, str.length(), str.length(), dp));

    }
}
