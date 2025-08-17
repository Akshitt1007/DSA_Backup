package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.ArrayList;

public class a4_Subsets {
    public static void main(String[] args) {

        String set = "abc";
        subseq( "" ,set );

        System.out.println();

        ArrayList<String> list = new ArrayList<>();
        System.out.print( subseqII( "", set, list) );

        System.out.println();

        System.out.println( subseqIII( "", set ) );

    }

    // Way 1:
    static void subseq ( String processed ,String set ){

        if ( set.isEmpty() ){
            System.out.print( processed + " ");
            return;
        }

        char ch = set.charAt(0);

        subseq( processed + ch, set.substring(1) );
        subseq( processed , set.substring(1) );
    }

    // Way 2:
    static ArrayList<String> subseqII (String processed, String set , ArrayList<String> list ){

        if ( set.isEmpty() ){
            list.add(processed);
            return list ;
        }

        char ch = set.charAt(0);

        subseqII( processed + ch , set.substring(1), list);

        subseqII( processed, set.substring(1), list);

        return list;
    }

    // Way 3:
    static ArrayList<String> subseqIII (String processed, String set){

//        ArrayList<String> list = new ArrayList<>();
//        if ( set.isEmpty() ){
//            list.add( processed );
//            return list;
//        }

        if ( set.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();
            list.add( processed );
            return list;
        }

        char ch = set.charAt(0);

        ArrayList<String> ans_from_left = subseqIII( processed + ch, set.substring(1) );
        ArrayList<String> ans_from_right = subseqIII( processed, set.substring(1) );

//        list.addAll( ans_from_left);
//        list.addAll(ans_from_right);
//        return list;

        ans_from_left.addAll( ans_from_right );
        return ans_from_left;

    }

}
