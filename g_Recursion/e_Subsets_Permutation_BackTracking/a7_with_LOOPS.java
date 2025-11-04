package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class a7_with_LOOPS {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };

        List<List<Integer>> ans = Subsets_with_LOOPs( arr );

        for ( List<Integer> list : ans ){
            System.out.println( list );
        }
    }

    static List<List<Integer>> Subsets_with_LOOPs( int[] arr ){

        List<List<Integer>> outer = new ArrayList<>();

        outer.add( new ArrayList<>() );

        for ( int num : arr ){
             int size = outer.size();

             for ( int i = 0; i < size ; i++ ){

                 List<Integer> internal = new ArrayList<>(outer.get(i));

                 internal.add( num );

                 outer.add( internal );
             }
        }

        return outer;
    }
}

/*
    TIME COMPLEXITY:

        total lvls / time taken


        1) time taken at each level is n
        2) and its getting double with each level
        3) total subsets = 2^n

            O ( n * 2^n )

 */
