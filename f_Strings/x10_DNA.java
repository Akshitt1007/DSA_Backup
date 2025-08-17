package f_Strings;

//187. Repeated DNA Sequences
//https://leetcode.com/problems/repeated-dna-sequences/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class x10_DNA {
    public static void main(String[] args) {

        System.out.println( findRepeatedDnaSequences( "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println( findRepeatedDnaSequences( "AAAAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        if ( s.length() < 10  ) {
            return new ArrayList<>();
        }

        ArrayList<String> str = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for( int i = 0; i <= s.length() - 10; i++ ) {
            String sub = s.substring(i, i + 10);

            if( !set.contains(sub) ) {

                for (int j = i + 1; j <= s.length() - 10; j++) {

                    String second_sub = s.substring(j, j + 10);

                    if( sub.equals(second_sub) ){

                        str.add(sub);
                        set.add(sub);

                        break;
                    }
                }
            }
        }
        return new ArrayList<>( str );
    }


    public static List<String> findRepeatedDnaSequences_Optimised(String s) {

        if ( s.length() < 10  || s.length() > 10000) {
            return new ArrayList<>();
        }

        HashSet<String> set = new HashSet<>();
        HashSet<String> Unique_Set = new HashSet<>();

        for( int i=0 ; i<=s.length()-10; i++ ){
            String sub = s.substring(i, i + 10);

            if( set.contains( sub ) ){
                Unique_Set.add( sub );
            }
            set.add(sub);
        }

        return new ArrayList<>( Unique_Set );
    }
}
