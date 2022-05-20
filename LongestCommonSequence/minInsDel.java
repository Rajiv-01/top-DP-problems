// program to find the minimum number of insertion and deletion required to make two strings equal

public class minInsDel {
    public static void main(String[] args) {
        String s1 = "heping";
        String s2 = "peaing";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // in this program we have to first find the common subsequence cause
        // we can know that these are the common elements in the two strings
        // so we have to find only those which are not equal and then have to delete and
        // insert
        int lcs = LongestCommonSequence.LCS(s1, s2, s1.length(), s2.length(), dp);
        // so converting 'heep' to 'ea' (which is the common subsequence) we need two
        // deletions
        // and to convert 'ea' to 'pea' we need one insertion
        int deletion = s1.length() - lcs;
        int insertion = s2.length() - lcs;
        System.out.println(deletion + " " + insertion);

    }
}
