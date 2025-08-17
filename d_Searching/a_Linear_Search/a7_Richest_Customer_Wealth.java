package d_Searching.Linear_Search;

public class a7_Richest_Customer_Wealth {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{3,2,9}};

        System.out.println("Maximum wealth is: " + maximum_wealth(array));
    }

    static int maximum_wealth(int [][] array ){

        int max = 0;

        for( int i=0 ; i<array.length ; i++ ){
            int wealth = 0;
            for( int j=0 ; j< array[i].length; j++){
                wealth = wealth + array[i][j];
            }
            if(wealth > max){
                max = wealth;
            }
        }
        return max;
    }
}
