package g_Recursion.e_Subsets_Permutation_BackTracking.a_Basic_Questions;

public class a2_skip_string {
    public static void main(String[] args) {

        String name = "i love apple";

        String new_name = skipApple ( name );
        System.out.println( new_name );


        String name1 = "i love apple and i watch apps";
        String new_name2 = skipApp_notApple( name1 );
        System.out.println( new_name2 );
    }

    // Skip a String ie "apple" from the current string
    static String skipApple( String up ){

        if (up.isEmpty()) {
            return "";
        }

        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        }
        else {
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }


    // Skip a String ie "app" only if "apple" is not there
    static String skipApp_notApple ( String name ){

        if ( name.isEmpty() ){
            return "";
        }

        if ( name.startsWith( "app" ) && !name.startsWith( "apple" ) ){
            return skipApp_notApple( name.substring( 3 ) );
        }
        else{
            return name.charAt(0) + skipApp_notApple( name.substring(1) );
        }
    }

    /*
        1) isEmpty(): Checks if the string is empty (length is 0).

        2) startsWith(String prefix): Checks if the string starts with the specified sequence of characters.

        3) substring(int beginIndex): Returns a substring starting from the given index up to the end of the string.

                -> The method up.substring(4) will return a substring of the string "up" starting from the 4th index (0-based indexing).
                   In the string "ccccddddefgh", the character at index 4 is d. So the substring will start from this character and include all characters after it.

                   Result:
                   up.substring(4) will return "ddddefgh"

     */

}
