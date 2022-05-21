// program to find the sequence pattern of one string in other string
// means to find if one string is in second string as a subsequence
public class sequencePatternMatching {
    public static void main(String[] args) {
        // we can do it in a way that we can find the lcs of the two strings and then
        // we can check if the length of the lcs is equal to the length of the string
        // which we are looking for then it is a sequqnce pattern
        String s1 = "abd";
        String s2 = "abfe";

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int lcs = LongestCommonSequence.LCS(s1, s2, len1, len2, dp);
        if (lcs == len1)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
