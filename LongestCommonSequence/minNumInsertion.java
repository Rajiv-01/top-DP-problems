// program to find the minimum number of insertion required to make the string palindromic
public class minNumInsertion {
    public static void main(String[] args) {
        String str = "asdgfdsa";
        String rev = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[str.length() + 1][str.length() + 1];

        // what we can do is to first find out the longest palindromic sub sequence then
        // we can
        // subtract the length of the longest palindromic subsequence from the length of
        // the string
        // which give us the minimum of insertion required because all characters left
        // should be single character
        // so we need to pair them up to make it palindromic
        int palindromSubSeq = LongestCommonSequence.LCS(str, rev, str.length(), str.length(), dp);
        System.out.println(str.length() - palindromSubSeq);
    }
}
