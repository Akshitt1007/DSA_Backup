package g_Recursion.e_Subsets_Permutation_BackTracking;

public class b3_Permutation_count {
    public static void main(String[] args) {

        String name = "abc";

        System.out.println( permutation_count( "", name, 0 ) );
    }

    static int permutation_count( String processced, String org, int count ){

        if ( org.isEmpty() ){
            count = count + 1;
            return count;
        }

        char ch = org.charAt(0);

        for ( int i = 0 ; i <= processced.length(); i++ ){

            String start = processced.substring( 0, i );
            String end = processced.substring( i, processced.length() );

            count = permutation_count( start + ch + end , org.substring(1) , count );
        }

        return count;
    }
}
