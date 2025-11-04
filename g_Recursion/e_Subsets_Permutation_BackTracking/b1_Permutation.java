package g_Recursion.e_Subsets_Permutation_BackTracking;
/*
            Tree diagram :

                            ("", "abc")
                                 |
                            Insert 'a'
                                 ↓
                            ("a", "bc")
                             /      \
                 Insert 'b' at 0   Insert 'b' at 1
                   ("ba", "c")      ("ab", "c")
                   /   |   \         /    |   \
               "cba" "bca" "bac"  "cab" "acb" "abc"

 */
public class b1_Permutation {
    public static void main(String[] args) {

        String set = "abc";

        permutation( "", set  );

    }

    static void permutation( String processed, String set ){

        if( set.isEmpty() ){
            System.out.println( processed );
            return;
        }

        char ch = set.charAt(0);

        for( int i = 0 ; i <= processed.length() ; i++ ){

            String start = processed.substring( 0, i );
            String end = processed.substring( i, processed.length() );

            permutation( start + ch + end, set.substring(1) );

//             permutation( processed.substring( 0, i ) + ch + processed.substring( i, processed.length() ), set.substring(1));
        }
    }

/*
    Substring [ begin index, end index )
    -> This is called a **half-open interval**.

    - [ ] means inclusive bracket => the value IS included
    - ( ) means exclusive bracket => the value is NOT included

    So in substring:
    - The beginning index is included (you start from it),
    - The end index is NOT included (you stop just *before* it).

    In simple words:
    - You take characters from 'begin' up to (but NOT including) 'end'.
    - That's why it's "[ )".

    Example:
        String = "HELLO"
        substring(1, 4) => "ELL"
            index 1 -> 'E' (included)
            index 2 -> 'L' (included)
            index 3 -> 'L' (included)
            index 4 -> STOP (not included)
*/

}
