package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.*;

public class b2_Permutation_wth_list {
    public static void main(String[] args) {

        String set = "abc";

        ArrayList<String> list = permutation_wth_list ( "", set );

        System.out.println( list );
    }

    static ArrayList<String> permutation_wth_list( String processed, String set ){

        if( set.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();

            list.add( processed );

            return list;
        }

        ArrayList<String> all = new ArrayList<>();

        char ch = set.charAt(0);

        for ( int i = 0 ; i <= processed.length() ; i++ ){

            String start = processed.substring( 0, i );
            String end = processed.substring( i, processed.length() );

            ArrayList<String> ans = permutation_wth_list( start + ch + end , set.substring(1) );

            all.addAll( ans );
        }

        return all;
    }
}
