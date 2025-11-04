package g_Recursion.e_Subsets_Permutation_BackTracking;

public class a6_ASCII {
    public static void main(String[] args) {

        String set = "abc";

        subsets_ascii( "", set);

    }

    static void subsets_ascii( String subsets, String org ){

        if ( org.isEmpty() ){

            if ( subsets.matches("\\d+") ){     // With this it will check if the string have only integers or not
                return;
            }

            System.out.print( subsets + " " );
            return;
        }

        char ch = org.charAt(0);

        subsets_ascii( subsets + ch , org.substring(1) );
        subsets_ascii(  subsets + (ch+0) , org.substring(1) );
        subsets_ascii( subsets , org.substring(1) );

    }
}
