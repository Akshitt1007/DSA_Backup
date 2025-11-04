package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.ArrayList;
/*
    keyboard:

        1       2       3
       null    abc     def
        4       5       6
       ghi     jkl     mno
        7       8       9
       pqrs    tuv     wxyz

       if we press 23 -> total possibility = ad, ae, af, bd, be, bf, cd, ce, cf
 */

public class c1_Letter_combo_of_Phone_number {
    public static void main(String[] args) {

        combo( "", "12" );

        System.out.println();

        ArrayList<String> list = combo_list( "", "12" );
        System.out.println( list );
    }

    static void combo ( String processed , String unprocessed ){

        if ( unprocessed.isEmpty() ){
            System.out.print( processed + " ");
            return;
        }

        int digit = unprocessed.charAt(0) - '0';        // convert '2' to 2

        for ( int i = (digit-1)*3 ; i < digit*3 ; i++ ){

            char ch = (char) ( 'a' + i );
            combo( processed + ch , unprocessed.substring(1) );
        }
    }


    static ArrayList<String> combo_list( String processed, String unprocessed ){

        if ( unprocessed.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();
            list.add( processed );
            return list;
        }

        ArrayList<String> all_ans = new ArrayList<>();

        int digit = unprocessed.charAt(0) - '0';

        for ( int i = (digit-1)*3 ; i < (digit*3) ; i++ ){

            char ch = (char) ( 'a' + i );
            ArrayList<String> ans = combo_list( processed + ch , unprocessed.substring(1) );

            all_ans.addAll( ans );
        }
        return all_ans;
    }





    /*
    static ArrayList<String> digit ( String one , String two  ){
        ArrayList<String> list = new ArrayList<>();

        for ( int i = 0 ; i< one.length() ; i++ ){
            ArrayList<String> ans = combo( String.valueOf(one.charAt(i)) , two );
            list.addAll( ans );
        }
        return list;
    }

    static ArrayList<String> combo ( String p, String up ){

        if ( up.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();
            if ( p.length() == 2 ){
                list.add( p );
            }
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = combo( p + ch  , up.substring(1) );
        ArrayList<String> right = combo( p  , up.substring(1) );
        left.addAll(right);

        return left;
    }
     */
}
