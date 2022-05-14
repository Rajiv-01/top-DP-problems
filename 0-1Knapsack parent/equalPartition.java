// program to check if we can divide our array in such a way that two subsets have equal sum

public class equalPartition {

    public static void main(String[] args) {
        int[] array = new int[] { 2, 5 };
        int len = array.length;
        int totalsum = 0;
        for (int i : array) {
            totalsum = totalsum + i;
        }
        if (totalsum % 2 != 0) {
            System.out.println(false);
            return;
        }
        int halfsum = totalsum / 2;
        // for equal partition we should have a subset which have sum=half of totalsum ,
        // so only then it will be equal
        // to other half, so for half sum we call the whole isSubsetSum method

        boolean[][] dp = new boolean[halfsum + 1][len + 1];
        boolean result = subset.isSubsetSum(array, halfsum, len, dp);
        System.out.println(result);

    }
}
