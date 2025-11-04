package g_Recursion;

import java.util.ArrayList;

// To find all the places where the target element has occurred

public class a6_Passing_ArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] array = { 1, 2, 3, 3, 4, 5, 6, 6, 3, 3, 10 };
        int target = 3;

        findI( array, target );             // global form
        findII( array , target , ans );  // in argument form

        System.out.println( listI );
        System.out.println( ans );
    }






    // By creating a global variable and storing in it
    // and printing the all array list afterward
    static ArrayList<Integer> listI = new ArrayList<>();

    static void findI ( int[] arr , int target){
        helper( arr , target, 0 );
    }

    static void helper( int[] arr, int target, int index ){

        if( index > arr.length-1 ){
            return;
        }

        if ( arr[index] == target ){
            listI.add( index+1 );
        }

        helper( arr, target , index+1 );
    }










    // By passing the Array list in the argument form only
    static void findII ( int[]arr, int target , ArrayList<Integer> ans ){
         helperII ( arr , target , ans , 0 );
    }

    static ArrayList<Integer> helperII ( int[]arr, int target , ArrayList<Integer> ans , int index ){

        if( index > arr.length-1 ){
            return ans;
        }

        if ( arr[index] == target ){
            ans.add( index+1 );
        }

        return helperII( arr, target , ans,index+1 );
    }
}
