// program to find the minimum number of deletion required to make string pralindromic
public class minDelToMakePalindrome {
    public static void main(String[] args) {
        String str = "asdgfdsa";
        String rev = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[str.length() + 1][str.length() + 1];

        // what we can do is to first find out the longest palindromic sub sequence then
        // we can
        // subtract the length of the longest palindromic subsequence from the length of
        // the string
        // which give us the minimum of deletion required
        int palindromSubSeq = LongestCommonSequence.LCS(str, rev, str.length(), str.length(), dp);
        System.out.println(str.length() - palindromSubSeq);
    }
}
