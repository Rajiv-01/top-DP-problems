
class knapsack{

    public static int knapsack0_1(int[] weight, int[] value, int capacity, int N,int[][] map){
      
        if(N==0 || capacity==0){
            return 0;
        }
         if(map[N][capacity]!=-1){
            return map[N][capacity];
        }
        if(weight[N-1]<=capacity){
            map[N][capacity] =Math.max(value[N-1]+knapsack0_1(weight,value,capacity-weight[N-1],N-1,map),knapsack0_1(weight,value,capacity,N-1,map));
        }
        else{
            map[N][capacity] =knapsack0_1(weight,value,capacity,N-1,map);
        }
        return map[N][capacity];
    }
    public static void main(String [] args){
        int[] weight = new int[]{1,2,3,4,1,6,7,8,8,9,9};
        int[] value = new int[]{4,6,2,7,1,3,8,3,25,6,2};
        int capacity = 20;
        int N=weight.length;
        int[][] map = new int[N+1][capacity+1];
        for(int i = 0; i < N + 1; i++){  
        for(int j = 0; j < capacity + 1; j++){  
            map[i][j] = -1; 
        }
    }  

        System.out.print(knapsack0_1(weight,value,capacity,N,map));

    }
}