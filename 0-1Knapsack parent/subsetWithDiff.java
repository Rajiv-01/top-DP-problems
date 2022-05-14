// program to find the count of two subsets with the given difference
public class subsetWithDiff {
    public static void main(String[] args) {
        int[] array = new int[] { 4, 5, 3, 6, 3 };
        int totalSum = 0;
        int diff = 3;
        for (int i : array) {
            totalSum += i;
        }
        // we will take first subset
        // if we have two subsets then
        // sum(sub1)+ sum(sub2) = totalsum
        // sum(sub1) - sum(sub2) = diff
        // adding two we got 2*sum(sub1)= totalsum + diff
        // sum(sub1) = (totalsum+diff)/2
        // so now we have to find the count of subset with given sum = sum(sub1)

        int subSum = (totalSum + diff) / 2;
        int len = array.length;
        int[][] dp = new int[subSum + 1][len + 1];
        // now we can call the countSubsetsum method to calculate the count
        System.out.println(countSubsetsum.countsub(array, subSum, len, dp));

    }
}
