// program to find the shortest common super sequence between two given strings
// common super sequence means we have to merge both strings together in shortest way possible so that both strings
// are in sequence in the final merged string
public class shortestCommonSuperSequence {

    public static void main(String[] args) {
        String s1 = "abddef";
        String s2 = "abddef";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int len1 = s1.length();
        int len2 = s2.length();
        // what we see here is that we have to first find the common subsequence cause
        // we can
        // use them only once in our merged result
        // so what we can do is calculate LCS(longest common subsequence) and the
        // calculate the result
        // as len(s1)+len(s2) - LCS
        int lcs = LongestCommonSequence.LCS(s1, s2, len1, len2, dp);
        System.out.println(len1 + len2 - lcs);
    }
}
