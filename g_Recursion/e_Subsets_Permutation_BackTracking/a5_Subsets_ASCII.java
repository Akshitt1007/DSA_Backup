package g_Recursion.e_Subsets_Permutation_BackTracking;

public class a5_Subsets_ASCII {
    public static void main(String[] args) {

        String set = "abc";

        Subsets_ASCII( "", set );
    }

    static void Subsets_ASCII( String processed, String set ){

        if ( set.isEmpty() ){
            int value = into_ASCII( processed , 0);
            System.out.print( value + " " );
            return;
        }

        char ch = set.charAt(0);

        Subsets_ASCII( ch + processed, set.substring(1) );
        Subsets_ASCII( processed, set.substring(1) );
    }

    static int into_ASCII( String processed , int value){

        if( processed.isEmpty() ){
            return value;
        }

        char ch = processed.charAt(0);
        value = ch + value;

        return into_ASCII( processed.substring(1), value) ;

    }
}
