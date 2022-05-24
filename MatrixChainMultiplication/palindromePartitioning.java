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

    public static int palindromePart(String str, int i, int j) {
        int min = str.length() - 1;
        if (i > j)
            return 0;
        if (isPalindrome(str.substring(i, j + 1)))
            return 0;
        for (int k = i; k < j; k++) {
            int count = palindromePart(str, i, k) + palindromePart(str, k + 1, j) + 1;
            if (count < min) {
                min = count;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        String str = "niti";
        System.out.println(palindromePart(str, 0, str.length() - 1));

    }
}
