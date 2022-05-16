// unbound knapsack is a problem same as that of 0-1 knapsack problem but it in this we have infinite number of items.
// means we can select one item more than once

public class unboundKnapsack {
    public static int Uknapsack(int[] weight, int[] value, int capacity, int N, int[][] map) {
        if (N == 0 || capacity == 0) {
            return 0;
        }
        if (map[N][capacity] != -1) {
            return map[N][capacity];
        }
        if (weight[N - 1] <= capacity) {
            map[N][capacity] = Math.max(value[N - 1] + Uknapsack(weight, value, capacity - weight[N - 1], N, map),
                    Uknapsack(weight, value, capacity, N - 1, map));
        } else {
            map[N][capacity] = Uknapsack(weight, value, capacity, N - 1, map);
        }
        return map[N][capacity];
    }

    public static void main(String[] args) {
        int[] weight = new int[] { 1, 2, 3, 4 };
        int[] value = new int[] { 2, 2, 2, 7 };
        int capacity = 10;
        int N = weight.length;
        int[][] map = new int[N + 1][capacity + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                map[i][j] = -1;
            }
        }

        System.out.print(Uknapsack(weight, value, capacity, N, map));

    }
}
