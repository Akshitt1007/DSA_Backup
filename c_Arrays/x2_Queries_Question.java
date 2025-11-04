package c_Arrays;
import java.util.ArrayList;

public class x2_Queries_Question {
    public static void main(String[] args) {

        int[] arr = { 3, 8, -5, -2, 0, 9, -3, 6, 8, -2, 7 };
        int[][] queries = { { 0, 3},
                { 1, 4},
                { 2, 6},
                { 8, 10},
                { 3, 5} };

        ArrayList<String> sum_between_given_index = getsum(arr, queries);
        System.out.println( sum_between_given_index );

    }

    public static ArrayList<String> getsum (int[] arr , int[][] arr2) {

        ArrayList<String> list = new ArrayList<>();

        for ( int i = 0 ; i < arr2.length ; i++ ){

            int sum = 0;

            for ( int j = arr2[i][0] ; j <= arr2[i][1] ; j++ ){

                sum = arr[j] + sum ;

            }
            list.add(String.valueOf(sum));
        }

        return list ;
    }
}
